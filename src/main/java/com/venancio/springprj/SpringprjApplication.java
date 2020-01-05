package com.venancio.springprj;

import com.venancio.springprj.domain.*;
import com.venancio.springprj.domain.enums.EstadoPagamento;
import com.venancio.springprj.domain.enums.TipoCliente;
import com.venancio.springprj.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootApplication
public class SpringprjApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringprjApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Categoria cat1 = new Categoria(null, "Informatica");
        Categoria cat2 = new Categoria(null, "Escritorio");
        Categoria cat3 = new Categoria(null, "Cama mesa e banho");
        Categoria cat4 = new Categoria(null, "Jardinagem");
        Categoria cat5 = new Categoria(null, "Pet");

        Produto p1 = new Produto(null, "Computador", 2000.00);
        Produto p2 = new Produto(null, "Monitor", 425.00);
        Produto p3 = new Produto(null, "Teclado", 40.00);

        Estado est1 = new Estado(null, "Paraiba");
        Estado est2 = new Estado(null, "Pernambuco");
        Estado est3 = new Estado(null, "São Paulo");

        Cidade cid1 = new Cidade(null, "João Pessoa", est1);
        Cidade cid2 = new Cidade(null, "Recife", est2);
        Cidade cid3 = new Cidade(null, "São Paulo", est3);

        Cliente cliente1 = new Cliente(null, "Adeeb", "gg@gmail.com", "521356689", TipoCliente.PESSOAFISICA);

        cliente1.getTelefones().addAll(Arrays.asList("52235436", "552264444"));

        Endereco e1 = new Endereco(null, "Rua Omega", "300", "apt1", "Font", "73773737", cliente1, cid1);

        cliente1.getEnderecos().addAll(Arrays.asList(e1));

        cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProdutos().addAll(Arrays.asList(p2));

        p1.getCategorias().addAll(Arrays.asList(cat1));
        p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
        p3.getCategorias().addAll(Arrays.asList(cat1));

        est1.getCidades().addAll(Arrays.asList(cid1));
        est2.getCidades().addAll(Arrays.asList(cid2));
        est3.getCidades().addAll(Arrays.asList(cid3));

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5));
        produtoRepository.saveAll((Arrays.asList(p1, p2, p3)));
        estadoRepository.saveAll((Arrays.asList(est1, est2, est3)));
        cidadeRepository.saveAll((Arrays.asList(cid1, cid2, cid3)));
        clienteRepository.saveAll((Arrays.asList(cliente1)));
        enderecoRepository.saveAll((Arrays.asList(e1)));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy hh:mm");

        Pedido ped1 = new Pedido(null, sdf.parse("30/09/2019 14:22"), cliente1, e1);
        Pedido ped2 = new Pedido(null, sdf.parse("30/09/2019 16:30"), cliente1, e1);

        Pagamento pag1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
        ped1.setPagamento(pag1);

        Pagamento pag2 = new PagamentoComCartao(null, EstadoPagamento.CANCELADO, ped2, 12);
        ped2.setPagamento(pag2);

        cliente1.getPedidos().addAll(Arrays.asList(ped1, ped2));

        pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
        pagamentoRepository.saveAll(Arrays.asList(pag1, pag2));

        ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
        ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
        ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);

        ped1.getItens().addAll(Arrays.asList(ip1, ip2));
        ped2.getItens().addAll(Arrays.asList(ip3));

        p1.getItens().addAll(Arrays.asList(ip1));
        p2.getItens().addAll(Arrays.asList(ip3));
        p3.getItens().addAll(Arrays.asList(ip2));

        itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));

    }
}
