/*
 * The MIT License (MIT)
 * 
 * Copyright (c) 2015 Madhavan Lakshminarayanan
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package javaPractice.java8.simplestream;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public final class SimpleStream<T> {
    private Stream<T> stream;

    private SimpleStream(Stream<T> stream) {
        this.stream = stream;
    }

    /**
     * Creates a {@link SimpleStream} wrapping the specified {@link Stream}.
     * 
     * @param stream the {@link Stream} to wrap
     */
    public static <T> SimpleStream<T> stream(Stream<T> stream) {
        return new SimpleStream<>(stream);
    }

    /**
     * Creates a {@link SimpleStream} backed by the specified {@link Collection}.
     * 
     * @param collection the source {@link Collection}
     */
    public static <T> SimpleStream<T> stream(Collection<T> collection) {
        return new SimpleStream<>(collection.stream());
    }

    /**
     * Creates a {@link SimpleStream} containing the specified values.
     * 
     * @param <T> the type of stream elements
     * @param values the values to create the stream from
     */
    @SafeVarargs
    public static <T> SimpleStream<T> stream(T... values) {
        return new SimpleStream<>(Stream.of(values));
    }

    /**
     * Returns whether all elements in this stream match the given predicate.
     * 
     * @param predicate the predicate to evaluate
     * @see Stream#allMatch(Predicate)
     */
    public boolean allMatch(Predicate<? super T> predicate) {
        return stream.allMatch(predicate);
    }

    /**
     * Returns whether at least one element in this stream matches the given predicate.
     * 
     * @param predicate the predicate to evaluate
     * @see Stream#anyMatch(Predicate)
     */
    public boolean anyMatch(Predicate<? super T> predicate) {
        return stream.anyMatch(predicate);
    }

    /**
     * Returns the arithmetic mean of the values in this stream.
     * 
     * @throws ClassCastException if the stream contains elements that cannot be cast to a {@link Number}
     * @see Collectors#averagingDouble(java.util.function.ToDoubleFunction)
     */
    public double average() {
        return stream.collect(Collectors.averagingDouble(t -> ((Number) t).doubleValue()));
    }
    
    /**
     * Casts the elements in this stream to the specified type.
     * <p>
     * Because of the lazy nature of streams, this may cause a {@link ClassCastException} at a later time
     * if an element cannot be cast to the specified type.
     * 
     * @param type the type to cast to
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public <R> SimpleStream<R> cast(Class<R> type) {
        return new SimpleStream<>((Stream) stream);
    }
    
    /**
     * Concatenates the specified stream to the end of this stream.
     * 
     * @param stream the stream to be concatenated to the end of this stream
     */
    public SimpleStream<T> concat(SimpleStream<T> stream) {
        this.stream = Stream.concat(this.stream, stream.stream);
        return this;
    }

    /**
     * Returns whether this stream contains the specified element.
     * 
     * @param value the element to search for
     */
    public boolean contains(T value) {
        return stream.anyMatch(t -> Objects.equals(t, value));
    }

    /**
     * Returns the count of elements in this stream.
     * 
     * @see Stream#count()
     */
    public long count() {
        return stream.count();
    }

    /**
     * Filters this stream to include only distinct elements.
     * 
     * @see Stream#distinct()
     */
    public SimpleStream<T> distinct() {
        this.stream = stream.distinct();
        return this;
    }

    /**
     * Returns an {@link Optional} value containing some element of this stream, if any.
     * 
     * @see Stream#findAny()
     */
    public Optional<T> findAny() {
        return stream.findAny();
    }

    /**
     * Returns an {@link Optional} value containing the first element of this stream, if any.
     * 
     * @see Stream#findFirst()
     */
    public Optional<T> findFirst() {
        return stream.findFirst();
    }

    /**
     * Applies the given one-to-many mapping function to the elements in this stream and flattens the result.
     * 
     * @param mapper the one-to-many mapping function to apply
     * @see Stream#flatMap(Function)
     */
    public <R> SimpleStream<R> flatMap(Function<? super T, SimpleStream<? extends R>> mapper) {
        return new SimpleStream<>(stream.flatMap(t -> mapper.apply(t).toStream()));
    }

    /**
     * Performs an action on each element in this stream.
     * 
     * @param action the action to perform
     * @see Stream#forEach(Consumer)
     */
    public void forEach(Consumer<? super T> action) {
        stream.forEach(action);
    }

    /**
     * Groups the elements in this stream according to the given classification function.
     * 
     * @param classifier the classifier function that maps elements to keys
     * @see Collectors#groupingBy(Function)
     */
    public <K> Map<K, List<T>> groupBy(Function<? super T, ? extends K> classifier) {
        return stream.collect(Collectors.groupingBy(classifier));
    }

    /**
     * Concatenates the elements of this stream into a string.
     * 
     * @return the concatenated string
     * @see Collectors#joining()
     */
    public String join() {
        return stream.map(Object::toString).collect(Collectors.joining());
    }

    /**
     * Concatenates the elements of this stream into a string using the specified delimiter.
     * 
     * @param delimiter the delimiter to be used between each element
     * @return the concatenated string 
     * @see Collectors#joining(CharSequence)
     */
    public String join(String delimiter) {
        return stream.map(Object::toString).collect(Collectors.joining(delimiter));
    }

    /**
     * Limits the maximum number of elements in this stream.
     * 
     * @param n the number of elements that the stream should be limited to
     * @see Stream#limit(long)
     */
    public SimpleStream<T> limit(long n) {
        this.stream = stream.limit(n);
        return this;
    }

    /**
     * Applies the given mapping function to the elements in this stream.
     * 
     * @param mapper the mapping function to apply
     * @see Stream#map(Function)
     */
    public <R> SimpleStream<R> map(Function<? super T, ? extends R> mapper) {
        return new SimpleStream<>(stream.map(mapper));
    }

    /**
     * Returns the maximum element of this stream according to their natural order.
     * <p>
     * Because of the lazy nature of streams, this may cause a {@link ClassCastException} at a later time
     * if the elements are not {@link Comparable}.
     * 
     * @see Stream#max(Comparator)
     */
    @SuppressWarnings("unchecked")
    public Optional<T> max() {
        return stream.max(defaultComparator());
    }

    /**
     * Returns the maximum element of this stream according to the given {@link Comparator}.
     * 
     * @param comparator the {@link Comparator} to use when comparing elements
     * @see Stream#max(Comparator)
     */
    public Optional<T> max(Comparator<? super T> comparator) {
        return stream.max(comparator);
    }

    /**
     * Returns the minimum element of this stream according to their natural order.
     * <p>
     * Because of the lazy nature of streams, this may cause a {@link ClassCastException} at a later time
     * if the elements are not {@link Comparable}.

     * @see Stream#min(Comparator)
     */
    @SuppressWarnings("unchecked")
    public Optional<T> min() {
        return stream.min(defaultComparator());
    }

    /**
     * Returns the minimum element of this stream according to the given {@link Comparator}.
     * 
     * @param comparator the {@link Comparator} to use when comparing elements
     * @see Stream#min(Comparator)
     */
    public Optional<T> min(Comparator<? super T> comparator) {
        return stream.min(comparator);
    }

    /**
     * Returns whether no elements in this stream match the given predicate.
     * 
     * @param predicate the predicate to evaluate
     * @see Stream#noneMatch(Predicate)
     */
    public boolean noneMatch(Predicate<? super T> predicate) {
        return stream.noneMatch(predicate);
    }
    
    /**
     * Sets the stream to parallel mode.
     * 
     * @see Stream#parallel()
     */
    public SimpleStream<T> parallel() {
        this.stream = stream.parallel();
        return this;
    }

    /**
     * Performs a reduction on the elements of this stream, using the given accumulation function.
     * If the stream could be empty, use {@link #reduce(T, BinaryOperator)} instead.
     * 
     * @param accumulator the accumulation function to be used to combine two elements
     * @throws NoSuchElementException if the stream is empty
     * @see Stream#reduce(BinaryOperator)
     */
    public T reduce(BinaryOperator<T> accumulator) {
        return stream.reduce(accumulator).get();
    }

    /**
     * Performs a reduction on the elements of this stream, using the given identity value
     * and accumulation function.
     *
     * @param identity the identity value for the accumulation function
     * @param accumulator the accumulation function to be used to combine two elements
     * @see Stream#reduce(T, BinaryOperator)
     */
    public T reduce(T identity, BinaryOperator<T> accumulator) {
        return stream.reduce(identity, accumulator);
    }

    /**
     * Filters this stream to remove elements that match the given predicate.
     * 
     * @param predicate the predicate to evaluate
     * @see Stream#filter(Predicate)
     */
    public SimpleStream<T> remove(Predicate<? super T> predicate) {
        return select(predicate.negate());
    }

    /**
     * Filters this stream to retain only elements of the specified type.
     * 
     * @param type the type of elements to retain
     */
    public <R> SimpleStream<R> select(Class<R> type) {
        return select(t -> type.isInstance(t)).cast(type);
    }

    /**
     * Filters this stream to retain only elements that match the given predicate.
     * 
     * @param predicate the predicate to evaluate
     * @see Stream#filter(Predicate)
     */
    public SimpleStream<T> select(Predicate<? super T> predicate) {
        this.stream = stream.filter(predicate);
        return this;
    }

    /**
     * Sets the stream to sequential mode.
     * 
     * @see Stream#sequential()
     */
    public SimpleStream<T> sequential() {
        this.stream = stream.sequential();
        return this;
    }

    /**
     * Skips the specified number of elements from this stream.
     * 
     * @param n the number of elements to skip
     * @see Stream#skip(long)
     */
    public SimpleStream<T> skip(long n) {
        this.stream = stream.skip(n);
        return this;
    }
    
    /**
     * Sorts the elements in this stream according to their natural order.
     * <p>
     * Because of the lazy nature of streams, this may cause a {@link ClassCastException} at a later time
     * if the elements are not {@link Comparable}.
     * 
     * @see Stream#sorted()
     */
    public SimpleStream<T> sort() {
        this.stream = stream.sorted();
        return this;
    }

    /**
     * Sorts the elements in this stream according to the given {@link Comparator}.
     * 
     * @param comparator the {@link Comparator} to use when comparing elements
     * @see Stream#sorted(Comparator)
     */
    public SimpleStream<T> sort(Comparator<? super T> comparator) {
        this.stream = stream.sorted(comparator);
        return this;
    }

    /**
     * Returns the sum of values in this stream as a double.
     * 
     * @throws ClassCastException if the stream contains elements that cannot be cast to a {@link Number}
     * @see Collectors#summingDouble(java.util.function.ToDoubleFunction)
     */
    public double sumAsDouble() {
        return stream.collect(Collectors.summingDouble(t -> ((Number) t).doubleValue()));
    }

    /**
     * Returns the sum of values in this stream as an integer.
     * 
     * @throws ClassCastException if the stream contains elements that cannot be cast to a {@link Number}
     * @see Collectors#summingInt(java.util.function.ToIntFunction)
     */
    public int sumAsInt() {
        return stream.collect(Collectors.summingInt(t -> ((Number) t).intValue()));
    }

    /**
     * Returns the sum of values in this stream as a long.
     * 
     * @throws ClassCastException if the stream contains elements that cannot be cast to a {@link Number}
     * @see Collectors#summingLong(java.util.function.ToLongFunction)
     */
    public long sumAsLong() {
        return stream.collect(Collectors.summingLong(t -> ((Number) t).longValue()));
    }
    
    /**
     * Returns an array containing the elements in this stream.
     * 
     * @param type the element type of the resulting array
     * @throws ArrayStoreException if the specified element type is not a supertype of
     * the runtime type of every element in this stream
     */
    @SuppressWarnings("unchecked")
    public <R> R[] toArray(Class<R> type) {
        return stream.toArray(n -> (R[]) Array.newInstance(type, n));
    }

    /**
     * Returns a {@link ConcurrentMap} containing key-value pairs derived from the elements in this stream.
     * 
     * @param keyMapper the key mapping function
     * @param valueMapper the value mapping function
     * @see Collectors#toConcurrentMap(Function, Function)
     */
    public <K, V> ConcurrentMap<K, V> toConcurrentMap(Function<? super T, ? extends K> keyMapper, Function<? super T, ? extends V> valueMapper) {
        return stream.collect(Collectors.toConcurrentMap(keyMapper, valueMapper));
    }

    /**
     * Returns a {@link List} containing the elements in this stream.
     * 
     * @see Collectors#toList()
     */
    public List<T> toList() {
        return stream.collect(Collectors.toList());
    }

    /**
     * Returns a {@link Map} containing key-value pairs derived from the elements in this stream.
     * 
     * @param keyMapper the key mapping function
     * @param valueMapper the value mapping function
     * @see Collectors#toMap(Function, Function)
     */
    public <K, V> Map<K, V> toMap(Function<? super T, ? extends K> keyMapper, Function<? super T, ? extends V> valueMapper) {
        return stream.collect(Collectors.toMap(keyMapper, valueMapper));
    }

    /**
     * Returns a {@link Set} containing the elements in this stream.
     * 
     * @see Collectors#toSet()
     */
    public Set<T> toSet() {
        return stream.collect(Collectors.toSet());
    }

    /**
     * Returns the underlying {@link Stream}.
     */
    public Stream<T> toStream() {
        return stream;
    }

    @SuppressWarnings("rawtypes")
    private Comparator defaultComparator() {
        return Comparator.naturalOrder();
    }
}
