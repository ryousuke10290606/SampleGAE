package com.appspot.samplegae;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Peson {
	//主キーフィールドにするために、@PrimaryKeyアノテーションを付与
	@PrimaryKey private String name;

	//データストアに保存するフィールドに、@Persistentアノテーションを付与
	@Persistent private String email;

	//コンストラクタ
	public Peson(String name,String email) {
		this.name = name;
		this.email =email;
	}

	//以下、getterとsetterを記載
	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
