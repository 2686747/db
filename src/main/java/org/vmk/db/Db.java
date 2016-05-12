package org.vmk.db;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.vmk.db.ds.Ds;

/**
 * Execute sql from file.
 * @author "Maksim Vakhnik"
 *
 */
public class Db {

	private final File file;
	private final Ds ds;
	
	/**
	 * 
	 * @param ds
	 * @param resource
	 */
	public Db(final Ds ds, final File resource) {
		this.ds = ds;
		this.file = resource;
	}
	
	/**
	 * Creates/updates tables in database.
	 * @throws SQLException
	 * @throws IOException
	 * @return either (1) the row count for SQL Data Manipulation Language (DML)
	 *  statements or (2) 0 for SQL statements that return nothing
	 */
	public int exec() throws SQLException, IOException {
		PreparedStatement ps = this.ds.dataSource()
			.getConnection().prepareStatement(sql());
		return ps.executeUpdate();
	}
	/**
	 * Reads sql statements from file
	 * @return 
	 * @throws IOException
	 */
	private String sql() throws IOException {
		return new String(Files.readAllBytes(this.file.toPath()));
	}
}
