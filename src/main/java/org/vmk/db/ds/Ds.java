package org.vmk.db.ds;

import java.sql.Connection;
import java.sql.SQLException;

public interface Ds {
	public Connection connection() throws SQLException;
}
