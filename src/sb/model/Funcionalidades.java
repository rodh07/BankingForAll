package sb.model;

import java.math.BigDecimal;



public interface Funcionalidades {

	public void deposito(Conta conta, BigDecimal valorDeposito);

	public void saque(Conta conta, BigDecimal valorSaque);

	public void transferencia(Conta conta, Conta contaRecebeTransf, BigDecimal valorTransf);

	public void pagamento(Conta conta, BigDecimal valorPagam);

	public void finalizarConta(Conta conta);

}
