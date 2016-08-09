package zeno.name.androidtestpractice;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author 陈治谋 (513500085@qq.com)
 * @since 16/8/8
 */
public class CalculatorTest
{
  private Calculator mCalculator;

  @Before
  public void setUp() throws Exception
  {
    mCalculator = new Calculator();
  }

  @Test
  public void testSum() throws Exception
  {
    //expected: 6, sum of 1 and 5
    assertEquals(6d, mCalculator.sum(1d, 5d), 0);
  }

  @Test
  public void testSubstract() throws Exception
  {
    assertEquals(1d, mCalculator.substract(5d, 4d), 0);
  }

  @Test
  public void testDivide() throws Exception
  {
    assertEquals(4d, mCalculator.divide(20d, 5d), 0);
  }

  @Test
  public void testMultiply() throws Exception
  {
    assertEquals(10d, mCalculator.multiply(2d, 5d), 0);
  }
}