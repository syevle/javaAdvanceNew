package javaPractice.java8.java_8_language_capabilities.implementing_strategy_pattern;

public class Asset {
  public enum AssetType { STOCK, BOND };
  
  public final AssetType type;
  public final int value;
  
  public Asset(AssetType assetType, int assetValue) {
    type = assetType;
    value = assetValue;
  }
}