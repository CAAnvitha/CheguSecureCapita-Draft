package com.anvitha.securecapita.repository.implementation;

import com.anvitha.securecapita.Exception.ApiException;
import com.anvitha.securecapita.domain.Role;
import com.anvitha.securecapita.repository.RoleRepository;
import com.anvitha.securecapita.rowmapper.RoleRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

import static com.anvitha.securecapita.query.RoleQuery.INSERT_ROLE_TO_USER_QUERY;
import static com.anvitha.securecapita.query.RoleQuery.SELECT_ROLE_BY_NAME_QUERY;
import static java.util.Map.of;
import static java.util.Objects.requireNonNull;

import static com.anvitha.securecapita.enumeration.RoleType.ROLE_USER;
import static com.anvitha.securecapita.enumeration.VerificationType.ACCOUNT;
import static com.anvitha.securecapita.query.UserQuery.INSERT_ACCOUNT_VERIFICATION_URL_QUERY;
import static com.anvitha.securecapita.query.UserQuery.INSERT_USER_QUERY;

@Repository
@RequiredArgsConstructor
@Slf4j
public class RoleRepositoryImpl implements RoleRepository<Role> {

    private final NamedParameterJdbcTemplate jdbc;

    @Override
    public Role create(Role data) {
        return null;
    }

    @Override
    public Collection<Role> list(int page, int pagesize) {
        return null;
    }

    @Override
    public Role get(Long id) {
        return null;
    }

    @Override
    public Role update(Role data) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    @Override
    public void addRoleToUser(Long userId, String roleName) {
        log.info("Adding role {} to user id {}",roleName,userId);
        try{
            Role role =jdbc.queryForObject(SELECT_ROLE_BY_NAME_QUERY,Map.of("name",roleName),new RoleRowMapper());
            jdbc.update(INSERT_ROLE_TO_USER_QUERY,Map.of("userId",userId,"roleId", Objects.requireNonNull(role).getId()));

        }
        catch(EmptyResultDataAccessException exception){
            throw new ApiException("No role found by name: "+ROLE_USER.name());
        }
        catch(Exception exception){
            log.error(exception.getMessage());
            throw new ApiException("An error occurred, Please Try Again Later");
        }
    }

    @Override
    public Role getRoleByUserId(long userId) {
        return null;
    }

    @Override
    public Role getRoleByUserEmail(String email) {
        return null;
    }

    @Override
    public void updateUserRole(Long userId, String roleName) {

    }
}

