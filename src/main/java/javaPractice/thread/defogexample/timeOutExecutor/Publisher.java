package javaPractice.thread.defogexample.timeOutExecutor;

public interface Publisher {
    public PublishResult publish(Article article) throws InterruptedException;
}
