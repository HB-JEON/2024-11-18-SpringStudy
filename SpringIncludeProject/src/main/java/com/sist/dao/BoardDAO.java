package com.sist.dao;


import org.springframework.stereotype.Repository;
import java.util.*;
import java.sql.*;
import com.sist.vo.*;

@Repository
public class BoardDAO {
	private Connection conn;
	private PreparedStatement ps;
}
