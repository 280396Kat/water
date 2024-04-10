package ru.it2g.h2o.dto.auth;

import lombok.Builder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Objects;

@Builder
public class CustomUserDetails implements UserDetails {

    private String userName;

    private String password;

    private Collection<GrantedAuthority> grantedAuthority;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { // для ролей, показывает как авторизованы пользователи
        return grantedAuthority;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() { // срок действия учётной записи. Проверяет срок действия
        return true;
    }

    @Override
    public boolean isAccountNonLocked() { // заблокированна или нет учётная запись
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() { // проверят пароль и смотрит, сколько им ещё можно пользоваться
        return true;
    }

    @Override
    public boolean isEnabled() { // активированна учётная запись или нет
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomUserDetails that = (CustomUserDetails) o;
        return Objects.equals(userName, that.userName) && Objects.equals(password, that.password) && Objects.equals(grantedAuthority, that.grantedAuthority);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, password, grantedAuthority);
    }

}
