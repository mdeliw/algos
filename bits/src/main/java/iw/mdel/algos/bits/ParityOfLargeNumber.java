package iw.mdel.algos.bits;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.apache.commons.lang3.StringUtils;

/**
 * Find parity of a really large (64-bit) number.
 * Learn about:
 *   short, int, long, random, printf, hashmap, bit shift, bit mask, XOR
 *   prefix small numbers with 0s
 *
 * Create a cache of parity of every 16-bit number. This can be Map.
 * Break the input into 4 16-bit number.
 * Determine parity of each 16-bit number using the cache.
 * XOR the individual parity value with each other to get the final parity.
 */

public class ParityOfLargeNumber {
  final static int BIT_MASK = 0xFFFF; // to force outcome to 16 bits
  final static int MASK_SIZE = 16; // to shift large number by 16 bits

  // 16-bit parity cache
  private static Map<Short, Short> parityCache = new HashMap<>();

  public static void main(String[] args) {
    long input = new Random().nextLong();
    System.out.printf("Input: %d, %s\n\n",
        input,
        StringUtils.leftPad(Long.toBinaryString(input),64, '0'));
    System.out.printf("\nParity: %d\n", ParityOfLargeNumber.solution(input));
  }

  /**
   * Solution
   * @param l - large number
   * @return parity
   */
  public static short solution(long l) {
    if (createParityCache().size() == 0) { // build parity lookup map once
      createParityCache();
    }
    short b3 = (short) (l >>> (MASK_SIZE * 3) & BIT_MASK);
    short b2 = (short) (l >>> (MASK_SIZE * 2) & BIT_MASK);
    short b1 = (short) (l >>> MASK_SIZE & BIT_MASK);
    short b0 = (short) (l & BIT_MASK);

    ParityOfLargeNumber.printResult(b3);
    ParityOfLargeNumber.printResult(b2);
    ParityOfLargeNumber.printResult(b1);
    ParityOfLargeNumber.printResult(b0);

    return (short) (parityCache.get(b3) ^
        parityCache.get(b2) ^
        parityCache.get(b1) ^
        parityCache.get(b0));
  }

  private static Map<Short, Short> createParityCache() {
    short s = Short.MIN_VALUE;
    for (int i = 0; i <= Math.abs(Short.MIN_VALUE) + Short.MAX_VALUE; i++) {
      parityCache.put(s, getParity(s));
      s++;
    }
    return parityCache;
  }

  private static short getParity(int x) {
    short result = 0;
    while (x != 0) {
      result ^= 1;
      x &= x - 1;
    }
    return result;
  }

  private static void printResult(short b) {
    System.out.printf("Parity of: %6d in %s is %d\n",
        b,
        StringUtils.leftPad(Integer.toBinaryString(b & 0xFFFF), 16, '0'),
        parityCache.get(b));
  }
}