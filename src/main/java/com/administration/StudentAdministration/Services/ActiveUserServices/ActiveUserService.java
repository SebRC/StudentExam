package com.administration.StudentAdministration.Services.ActiveUserServices;

import java.security.Principal;


public interface ActiveUserService
{
    Principal getActiveUserRole(Principal principal);
}
