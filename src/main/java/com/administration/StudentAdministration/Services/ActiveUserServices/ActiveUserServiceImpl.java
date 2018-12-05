package com.administration.StudentAdministration.Services.ActiveUserServices;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Service
public class ActiveUserServiceImpl implements ActiveUserService
{

    @ResponseBody
    @Override
    public Principal getActiveUserRole(Principal principal)
    {
        return principal;
    }
}
