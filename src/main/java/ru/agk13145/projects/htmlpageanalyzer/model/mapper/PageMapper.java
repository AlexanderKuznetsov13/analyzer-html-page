package ru.agk13145.projects.htmlpageanalyzer.model.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.agk13145.projects.htmlpageanalyzer.model.Page;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PageMapper implements RowMapper<Page> {

    @Override
    public Page mapRow(ResultSet resultSet, int i) throws SQLException {
        Page page = new Page();
        page.setId(resultSet.getInt("ID"));
        page.setUrl(resultSet.getString("URL"));
//        page.setStatisticJSON(resultSet);

        return page;
    }
}
