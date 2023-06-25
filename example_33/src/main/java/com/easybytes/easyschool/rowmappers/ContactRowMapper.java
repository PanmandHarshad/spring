package com.easybytes.easyschool.rowmappers;

import com.easybytes.easyschool.model.BaseEntity;
import com.easybytes.easyschool.model.Contact;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class ContactRowMapper implements RowMapper<Contact> {
    @Override
    public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
        LocalDateTime updated_at = null;
        if (null != rs.getTimestamp("UPDATED_AT")) {
            updated_at = rs.getTimestamp("UPDATED_AT").toLocalDateTime();
        }

        BaseEntity baseEntity = new BaseEntity(rs.getTimestamp("CREATED_AT").toLocalDateTime(),
                rs.getString("CREATED_BY"), updated_at, rs.getString("UPDATED_BY"));

        return new Contact(rs.getInt("CONTACT_ID"), rs.getString("NAME"),
                rs.getString("MOBILE_NUM"), rs.getString("EMAIL"),
                rs.getString("SUBJECT"), rs.getString("MESSAGE"),
                rs.getString("STATUS"), baseEntity);
    }
}
