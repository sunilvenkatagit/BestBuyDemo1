package com.bestbuy.enumrations;

public enum UserInfo {
	    EMAIL ("pvsunil1993@gmail.com"),
		FIRST_NAME  ("venkata sunil"),
		LAST_NAME   ("siminiuc"),
		ADDRESS     ("200 broadway"),
		CITY        ("vancouver"),	
		PROVINCE    ("BC"),
		POSTAL_CODE ("V6K 1A2"),
		PHONE_NUMBER ("(514) 699–7932")
		;
			
		private String value;
		 
		private UserInfo(String value) {
			this.value = value;
		}
		
		@Override
		public String toString() {
			return value;
		}

	}

