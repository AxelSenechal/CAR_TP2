package com.example.demo3.account;

import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, String> {

    Account findByMail(String mail);
    Account findByMailAndMdp (String mail, String mdp);

}
