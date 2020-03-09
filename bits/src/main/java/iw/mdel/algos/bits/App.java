package iw.mdel.algos.bits;

/**
 * Bit algos
 */

public class App {
  public static boolean isEven(int x) {
    return (x & 1) == 0 ? true: false;
  }

  public static boolean isNthBitSet(int x, int n) {
    return (x & (1 << n)) > 0 ? true: false;
  }

  public static int setNthBit(int x, int n) {
    return x | (1 << n);
  }

  public static int unsetNthBit(int x, int n) {
    return x & ~(1 << n);
  }

  public static int toggleNthBit(int x, int n) {
    return x ^ (1 << n);
  }

  // 01011000 => 01010000
  public static int unsetRightmost1Bit(int x) {
    return x & (x - 1);
  }

  // 10100111 => 10101111
  public static int setRightmost0Bit(int x) {
    return x | (x + 1);
  }

  // 01011000 => 00001000
  public static int isolateRightmost1Bit(int x) {
    return x & (~x + 1); // two's complement
  }

  // 01011001 => 00000010
  public static int isolateRightmost0Bit(int x) {
    return ~x & (x + 1);
  }

  //01011000 => 01011111
  public static int rightPropagateRightmost1Bit(int x) {
    return x | (x - 1);
  }

  // 10100111 => 10100000
  public static int turnOffTrailing1Bits(int x) {
    return x & (x + 1);
  }

  // 10101000 => 10101111
  public static int turnOnTrailing0Bits(int x) {
    return x | (x - 1);
  }

  // 10101000 => 11110111
  public static int all1BitsExceptUnsetRightmost1Bit(int x) {
    return ~x | (x - 1);
  }

  // 01011000 => 00000111
  public static int all0BitsExceptSetTrailing0Bits(int x) {
    return ~x & (x - 1);
  }

  // 10100111 => 11111000
  public static int all1BitsExceptUnsetTrailing1Bits(int x) {
    return ~x | (x + 1);
  }

  // 01010111 => 00001111
  public static int all0BitsExceptSetRightmost0BitWithTrailing1Bits(int x) {
    return x ^ (x + 1);
  }

  public static boolean areOppositeSigns(int x, int y) {
    return (x ^ y) < 0 ? true : false;
  }

  public static boolean isPowerOf2(int x) {
    return (x & (x - 1)) == 0;
  }

  /**
   *
   * @param a - merge if mask is 0
   * @param b - merge if mask is 1
   * @param m - mask, 1 means use b, 0 means use a
   * @return
   */
  public static int mergeBasedOnMask(int a, int b, int m) {
    return a ^ ((a ^ b) & m);
  }
}
