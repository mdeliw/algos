package iw.mdel.algos.bits;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
  @DisplayName("Test isEven()")
  @Test
  void testIsEven() {
    assertEquals(true, App.isEven(2));
    assertEquals(false, App.isEven(3));
  }

  @DisplayName("Test isNthBitSet()")
  @Test
  void testIsNthBitSet() {
    assertEquals(true, App.isNthBitSet(0b00001000, 3));
    assertEquals(true, App.isNthBitSet(0b10001001, 3));
    assertEquals(false, App.isNthBitSet(0b1010001, 3));
  }

  @DisplayName("Test setNthBit()")
  @Test
  void testSetNthBit() {
    assertEquals(0b1010, App.setNthBit(0b1000,1));
  }

  @DisplayName("Test unsetNthBit()")
  @Test
  void testUnsetNthBit() {
    assertEquals(0b0000, App.unsetNthBit(0b1000,3));
  }

  @DisplayName("Test toggleNthBit()")
  @Test
  void testToggleNthBit() {
    assertEquals(0b0000, App.toggleNthBit(0b1000,3));
    assertEquals(0b1000, App.toggleNthBit(0b0000,3));
  }

  @DisplayName("Test unsetRightMost1Bit()")
  @Test
  void testUnsetRightMost1Bit() {
    assertEquals(0b0000, App.unsetRightmost1Bit(0b0100));
    assertEquals(0b1000, App.unsetRightmost1Bit(0b1010));
    assertEquals(0b01010000, App.unsetRightmost1Bit(0b01011000));
  }

  @DisplayName("Test setRightMost0Bit()")
  @Test
  void testsetRightMost0Bit() {
    assertEquals(0b10101111, App.setRightmost0Bit(0b10100111));
  }

  @DisplayName("Test isolateRightmost1Bit()")
  @Test
  void testIsolateRightmost1Bit() {
    assertEquals(0b00001000, App.isolateRightmost1Bit(0b01011000));
  }

  @DisplayName("Test isolateRightmost0Bit()")
  @Test
  void testIsolateRightmost0Bit() {
    assertEquals(0b00000010, App.isolateRightmost0Bit(0b01011001));
  }

  @DisplayName("Test rightPropagateRightmost1Bit()")
  @Test
  void testRightPropagateRightmost1Bit() {
    assertEquals(0b01011111, App.rightPropagateRightmost1Bit(0b01011000));
  }

  @DisplayName("Test turnOffTrailing1Bits()")
  @Test
  void testTurnOffTrailing1Bits() {
    assertEquals(0b10100000, App.turnOffTrailing1Bits(0b10100111));
  }

  @DisplayName("Test turnOnTrailing0Bits()")
  @Test
  void testTurnOnTrailing0Bits() {
    assertEquals(0b10101111, App.turnOnTrailing0Bits(0b10101000));
  }

  @DisplayName("Test all1BitsExceptUnsetRightmost1Bit()")
  @Test
  void testAll1BitsExceptUnsetRightmost1Bit() {
    assertEquals(0b11111111111111111111111111110111, App.all1BitsExceptUnsetRightmost1Bit(0b10101000));
  }

  @DisplayName("Test all0BitsExceptSetTrailing0Bits()")
  @Test
  void testAll0BitsExceptSetTrailing0Bits() {
    assertEquals(0b00000111, App.all0BitsExceptSetTrailing0Bits(0b01011000));
  }

  @DisplayName("Test all1BitsExceptUnsetTrailing1Bits()")
  @Test
  void testAll1BitsExceptUnsetTrailing1Bits() {
    assertEquals(0b11111111111111111111111111111000, App.all1BitsExceptUnsetTrailing1Bits(0b10100111));
  }

  @DisplayName("Test all0BitsExceptSetRightmost0BitWithTrailing1Bits()")
  @Test
  void testAll0BitsExceptSetRightmost0BitWithTrailing1Bits() {
    assertEquals(0b00001111, App.all0BitsExceptSetRightmost0BitWithTrailing1Bits(0b01010111));
  }

  @DisplayName("Test areOppositeSigns()")
  @Test
  void testareOppositeSigns() {
    assertEquals(true, App.areOppositeSigns(2, -4));
    assertEquals(false, App.areOppositeSigns(-8, -4));
  }

  @DisplayName("Test isPowerOf2()")
  @Test
  void testIsPowerOf2() {
    assertEquals(true, App.isPowerOf2(0b00001000));
    assertEquals(false, App.isPowerOf2(0b00001001));
  }

  @DisplayName("Test mergeBasedOnMask()")
  @Test
  void testMergeBasedOnMask() {
    assertEquals(0b10000101, App.mergeBasedOnMask(0b10001010, 0b01110101, 0b00001111));
  }
}
