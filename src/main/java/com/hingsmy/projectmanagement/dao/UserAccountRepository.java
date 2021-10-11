package com.hingsmy.projectmanagement.dao;

import com.hingsmy.projectmanagement.entities.UserAccount;
import org.springframework.data.repository.CrudRepository;

public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {
}
