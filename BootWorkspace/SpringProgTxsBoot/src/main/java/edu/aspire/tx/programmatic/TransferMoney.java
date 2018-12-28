package edu.aspire.tx.programmatic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import edu.aspire.pojos.Deposit;
import edu.aspire.pojos.Withdraw;
import edu.aspire.prog.daos.DepositDaoImpl;
import edu.aspire.prog.daos.WithdrawDaoImpl;

@Service("transferMoney")
public class TransferMoney implements ITransferMoney {
	@Autowired
	private TransactionTemplate txTemplate;
	
	@Autowired
	private WithdrawDaoImpl withdrawdao;
	
	@Autowired
	private DepositDaoImpl depositdao;
	
	public void transfer(final int fromAccNo, final int toAccNo) {
		// txTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		// txTemplate.setIsolationLevel(TransactionDefinition.ISOLATION_DEFAULT);
		txTemplate.execute(new TransactionCallback() {
			public Object doInTransaction(TransactionStatus arg0) {
				try {
					Withdraw w = withdrawdao.read(fromAccNo);	//SELECT
					w.setAmount(w.getAmount() - 100);
					withdrawdao.update(w);						//UPDATE

					//if(true) throw new Exception();

					Deposit d = depositdao.read(toAccNo);		//SELECT
					d.setAmount(d.getAmount() + 100);
					depositdao.update(d);						//UPDATE
				} catch (Exception e) {
					System.out.println("catch block....");
					e.printStackTrace();
					arg0.setRollbackOnly();
				}
				return null;
			}
		});
	}
}
