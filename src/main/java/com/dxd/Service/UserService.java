package com.dxd.Service;

import com.dxd.po.User;

public interface UserService {
    User checkUser(String username, String password);
}
