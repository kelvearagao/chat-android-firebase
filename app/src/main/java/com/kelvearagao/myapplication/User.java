package com.kelvearagao.myapplication;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by CLEIDE on 02/11/2016.
 */

@IgnoreExtraProperties
public class User {

    public String nome;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "User{" +
                "nome='" + nome + '\'' +
                '}';
    }
}