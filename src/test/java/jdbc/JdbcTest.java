package jdbc;

import org.junit.Test;

import util.JdbcUtil;

public class JdbcTest {
	@Test
	public void testJdbc() {
       System.out.println(JdbcUtil.getConnection());
	}
}
