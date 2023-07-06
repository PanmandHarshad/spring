package com.easybytes.easyschool.rowmappers;

import com.easybytes.easyschool.model.BaseEntity;
import com.easybytes.easyschool.model.Holiday;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class HolidayRowMapper implements RowMapper<Holiday> {

    @Override
    public Holiday mapRow(ResultSet rs, int rowNum) throws SQLException {
        LocalDateTime updated_at = null;
        if (null != rs.getTimestamp("UPDATED_AT")) {
            updated_at = rs.getTimestamp("UPDATED_AT").toLocalDateTime();
        }

        BaseEntity baseEntity = new BaseEntity(rs.getTimestamp("CREATED_AT").toLocalDateTime(),
                rs.getString("CREATED_BY"), updated_at, rs.getString("UPDATED_BY"));

        return new Holiday(rs.getString("DAY"), rs.getString("REASON"),
                Holiday.Type.valueOf(rs.getString("TYPE")), baseEntity);
    }
}
