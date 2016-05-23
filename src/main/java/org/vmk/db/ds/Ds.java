package org.vmk.db.ds;

import java.sql.SQLException;

import javax.sql.DataSource;

public interface Ds {
	DataSource dataSource() throws SQLException;
}
