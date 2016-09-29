package sb.model;

import java.math.BigDecimal;

public interface Funcionalidades {

	public void deposito(Conta conta, BigDecimal valorDeposito);

	public boolean saque(Conta conta, BigDecimal valorSaque, String senhaInformada);

	public boolean transferencia(Conta conta, Conta contaRecebeTransf, BigDecimal valorTransf);

	public void finalizarConta(Conta conta);
	
	public void contaAlterada(Conta conta);

	boolean pagamento(Conta conta, BigDecimal valorPagamento, String codigoDeBarras);

}
