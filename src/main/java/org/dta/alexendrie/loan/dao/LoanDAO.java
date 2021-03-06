package org.dta.alexendrie.loan.dao;

import java.util.Date;

import javax.persistence.EntityManager;

import org.dta.alexendrie.dao.DatabaseHelper;
import org.dta.alexendrie.loan.model.Loan;
import org.dta.alexendrie.media.model.Media;
import org.dta.alexendrie.member.model.Member;

public class LoanDAO {

	public static Loan creationEmprunt(Member member, Media media, Date dateEmprunt) {

		EntityManager em = DatabaseHelper.createEntityManager();

		DatabaseHelper.beginTx(em);
		
		Loan insertion = new Loan(member, media, dateEmprunt);

		em.persist(insertion);

		DatabaseHelper.commitTxAndClose(em);
		
		return insertion;
	}

}
