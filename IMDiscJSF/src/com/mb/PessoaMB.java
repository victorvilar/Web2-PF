package com.mb;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.model.Pessoa;

@ManagedBean(name = "PessoaMB")
@SessionScoped
public class PessoaMB implements Serializable {
	private static final long serialVersionUID = -329216827348989761L;

	private Pessoa pessoa;
	
	
	
}
