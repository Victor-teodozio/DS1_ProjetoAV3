package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.example.demo.Ds1ProjetoAv3Application;
import com.example.demo.domain.Cartao;
import com.example.demo.domain.Categoria;
import com.example.demo.domain.Cliente;
import com.example.demo.domain.Conta;
import com.example.demo.domain.Endereco;
import com.example.demo.domain.Fatura;
import com.example.demo.repository.CartaoRepository;
import com.example.demo.repository.CategoriaRepository;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.ContaRepository;
import com.example.demo.repository.EnderecoRepository;
import com.example.demo.repository.FaturaRepository;

@SpringBootApplication
public class Ds1ProjetoAv3Application implements CommandLineRunner{

	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	ContaRepository contaRepository;
	
	@Autowired
	CartaoRepository cartaoRepository;
	
	@Autowired
	FaturaRepository faturaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Ds1ProjetoAv3Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Categoria categoria1 = new Categoria(null, "Bronze");
		Categoria categoria2 = new Categoria(null, "Silver");
		Categoria categoria3 = new Categoria(null, "Gold");
		
		Endereco endereco1 = new Endereco(null, "RUA 01", "2440", "Centro", "Fortaleza", "CE");
		Endereco endereco2 = new Endereco(null, "RUA 02", "852", "Fatima", "Fortaleza", "CE");
		Endereco endereco3 = new Endereco(null, "RUA 03", "521", "Aldeota", "Fortaleza", "CE");
		
		Cliente cliente1 = new Cliente(null, "Victor", "85987654321", "victor@email.com");
		Cliente cliente2 = new Cliente(null, "Marcio", "85123456789", "marcio@email.com");
		Cliente cliente3 = new Cliente(null, "Lucas", "85321654987", "lucas@email.com");
		
		Conta conta1 = new Conta(null, 123456789, 521.00, true, categoria2, cliente2);
		Conta conta2 = new Conta(null, 987654321, 752.36, true, categoria1, cliente1);
		Conta conta3 = new Conta(null, 741258963, 459.07, true, categoria3, cliente3);

		Cartao cartao1 = new Cartao(null, 316546564, sdf.parse("01/03/2030"), cliente1.getNome(), 123, "1234", conta1);
		Cartao cartao2 = new Cartao(null, 687332113, sdf.parse("02/02/2040"), cliente2.getNome(), 456, "4567", conta3);
		Cartao cartao3 = new Cartao(null, 981632715, sdf.parse("03/01/2025"), cliente3.getNome(), 789, "8910", conta2);
		
		Fatura fatura1 = new Fatura(null, sdf.parse("03/07/2020"), sdf.parse("02/06/2020"), 0, true, 521.00, cartao1);
		Fatura fatura2 = new Fatura(null, sdf.parse("03/07/2020"), sdf.parse("02/06/2020"), 0, true, 752.36, cartao1);
		Fatura fatura3 = new Fatura(null, sdf.parse("03/07/2020"), sdf.parse("02/06/2020"), 0, true, 459.07, cartao1);
		Fatura fatura4 = new Fatura(null, sdf.parse("02/07/2020"), sdf.parse("01/06/2020"), 0, true, 65.74, cartao2);
		Fatura fatura5 = new Fatura(null, sdf.parse("02/07/2020"), sdf.parse("01/06/2020"), 0, true, 22.85, cartao2);
		Fatura fatura6 = new Fatura(null, sdf.parse("02/07/2020"), sdf.parse("01/06/2020"), 0, true, 17.49, cartao2);
		Fatura fatura7 = new Fatura(null, sdf.parse("01/07/2020"), sdf.parse("30/06/2020"), 0, true, 369.74, cartao3);
		Fatura fatura8 = new Fatura(null, sdf.parse("01/07/2020"), sdf.parse("30/06/2020"), 0, true, 918.34, cartao3);
		Fatura fatura9 = new Fatura(null, sdf.parse("01/07/2020"), sdf.parse("30/06/2020"), 0, true, 549.23, cartao3);
		
		cliente1.setContas(conta2);
		cliente2.setContas(conta1);
		cliente3.setContas(conta3);
		cliente1.getEnderecos().addAll(Arrays.asList(endereco1));
		cliente2.getEnderecos().addAll(Arrays.asList(endereco2));
		cliente3.getEnderecos().addAll(Arrays.asList(endereco3));
		
		conta1.getCartoes().addAll(Arrays.asList(cartao1));
		conta2.getCartoes().addAll(Arrays.asList(cartao2));
		conta3.getCartoes().addAll(Arrays.asList(cartao3));
		
		cartao1.getFaturas().addAll(Arrays.asList(fatura1, fatura2, fatura3));
		cartao2.getFaturas().addAll(Arrays.asList(fatura4, fatura5, fatura6));
		cartao3.getFaturas().addAll(Arrays.asList(fatura7, fatura8, fatura9));
	
		categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2, categoria3));
		enderecoRepository.saveAll(Arrays.asList(endereco1, endereco2, endereco3));
		clienteRepository.saveAll(Arrays.asList(cliente1, cliente2, cliente3));
		contaRepository.saveAll(Arrays.asList(conta1, conta2, conta3));
		cartaoRepository.saveAll(Arrays.asList(cartao1, cartao2, cartao3));
		faturaRepository.saveAll(Arrays.asList(fatura1, fatura2, fatura3, fatura4, fatura5, fatura6, fatura7, fatura8));
		
	}

}


