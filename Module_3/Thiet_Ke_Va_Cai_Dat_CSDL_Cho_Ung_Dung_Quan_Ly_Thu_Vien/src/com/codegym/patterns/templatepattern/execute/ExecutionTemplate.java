package com.codegym.patterns.templatepattern.execute;

import java.sql.*;

public abstract class ExecutionTemplate {
    public abstract ResultSet execute(String queryStr);
}
