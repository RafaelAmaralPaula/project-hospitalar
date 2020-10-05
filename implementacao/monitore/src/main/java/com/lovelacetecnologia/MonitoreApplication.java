package com.lovelacetecnologia;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.lovelacetecnologia.spring.entity.Consulta;
import com.lovelacetecnologia.spring.entity.Especialidade;
import com.lovelacetecnologia.spring.entity.Medico;
import com.lovelacetecnologia.spring.entity.Paciente;
import com.lovelacetecnologia.spring.entity.Usuario;
import com.lovelacetecnologia.spring.service.ConsultaService;
import com.lovelacetecnologia.spring.service.EspecialidadeService;
import com.lovelacetecnologia.spring.service.MedicoService;
import com.lovelacetecnologia.spring.service.PacienteService;
import com.lovelacetecnologia.spring.service.UsuarioService;

@SpringBootApplication
public class MonitoreApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(MonitoreApplication.class, args);

		UsuarioService usuarioService = run.getBean(UsuarioService.class);

		// INSERIR USUARIO
		 usuarioService.salvar(criandoUsuario());

		// ALTERAR USUARIO
		 usuarioService.alterar(criandoUsuarioParaAlterar());

		// LISTAR TODOS USUARIOS
		imprimirTodosUsuarios(usuarioService.listarTodos());

		// DELETAR
		 usuarioService.deletar(1);

		// BUSCAR PELO CODIGO
		imprimirUsuario(usuarioService.buscarPeloCodigo(3));

		EspecialidadeService especialidadeService = run.getBean(EspecialidadeService.class);

		// SALVAR ESPECIALIDADE
		 especialidadeService.salvar(criandoEspecialidade());

		// ALTERAR ESPECIALIDADE
		 especialidadeService.alterar(criandoEspecialidadeParaAlterar());

		// DELETAR ESPECIALIDADE
		 especialidadeService.deletar(1);

		// LISTAR TODAS ESPECIALIDADE
		imprimirTodasEspecialidades(especialidadeService.listarTodasEspecialidades());

		// BUSCAR ESPECILIDADE PELO CÓDIGO
		imprimirEspecialidade(especialidadeService.buscarPeloCodigo(3));

		MedicoService medicoService = run.getBean(MedicoService.class);

		// SALVAR MEDICO
		 medicoService.salvar(criandoMedico(especialidadeService.buscarPeloCodigo(3)));

		// ALTERAR MÉDICO
		 medicoService.alterar(criandoMedicoParaAlterar(especialidadeService.buscarPeloCodigo(3)));

		// DELETAR MEDICO
		 medicoService.deletar(4);

		// LISTAR TODOS MEDICOS
		imprimirTodosMedicos(medicoService.listarTodosMedicos());

		// BUSCAR MEDICO PELO ID
		imprimirMedico(medicoService.buscarPeloCodigo(2));

		PacienteService pacienteService = run.getBean(PacienteService.class);

		// SALVAR PACIENTE
		 pacienteService.salvar(criandoPaciente());

		// ALTERAR UM PACIENTE
		 pacienteService.alterar(criandoPacienteParaAlterar());

		// DELETANDO UM PACIENTE
		 pacienteService.deletar(1);

		// LISTAR TODOS PACIENTE
		imprimirTodosPacientes(pacienteService.listarTodosPacientes());

		// BUSCAR PACIENTE PELO ID
		 imprimirPaciente(pacienteService.buscarPeloCodigo(4));

		ConsultaService consultaService = run.getBean(ConsultaService.class);
		Paciente paciente = pacienteService.buscarPeloCodigo(2);
		Medico medico = medicoService.buscarPeloCodigo(3);

		// SALVANDO CONSULTA
		consultaService.salvar(criandoConsulta(medico, paciente));

		// ALTERANDO CONSULTA
		 consultaService.alterar(criandoConsultaAlterar(medico, paciente));

		// DELETANDO UMA CONSULTA
		 consultaService.deletar(1);

		// LISTANDO TODAS CONSULTA
		 imprimirTodasConsultas(consultaService.listarTodasConsultas());

		// BUSCANDO CONSULTA PELO ID
		imprimirConsulta(consultaService.buscarPeloCodigo(2));

	}

//	@Bean
//	public ClasseExterna newClassExterna() {
//		return new ClasseExterna();
//	}

	static Usuario criandoUsuario() {
		Usuario usuario = new Usuario();
		usuario.setNome("Rafael");
		usuario.setUsername("admin");
		usuario.setSenha("24224");

		return usuario;
	}

	static Usuario criandoUsuarioParaAlterar() {
		Usuario usuario = new Usuario();
		usuario.setCodigo(1);
		usuario.setNome("Gleyson");
		usuario.setUsername("dev");
		usuario.setSenha("44646");

		return usuario;
	}

	static void imprimirTodosUsuarios(List<Usuario> listaUsuarios) {
		for (Usuario usuario : listaUsuarios) {
			System.out.println("Usuario ID -> " + usuario.getCodigo());
			System.out.println("Nome -> " + usuario.getNome());
			System.out.println("Username -> " + usuario.getUsername());
			System.out.println("Password -> " + usuario.getSenha());
			System.out.println("Status -> " + usuario.isAtivo());

			System.out.println("\n\n");

		}
	}

	static void imprimirUsuario(Usuario usuarioEncontrado) {
		System.out.println("Nome -> " + usuarioEncontrado.getNome());
		System.out.println("Username -> " + usuarioEncontrado.getUsername());
		System.out.println("Password -> " + usuarioEncontrado.getSenha());
		System.out.println("Ativo -> " + usuarioEncontrado.isAtivo());

		System.out.println("\n\n");

	}

	// ESPECIALIDADE
	static Especialidade criandoEspecialidade() {
		Especialidade especialidade = new Especialidade();
		especialidade.setNome("Psicogeriatria");

		return especialidade;
	}

	static Especialidade criandoEspecialidadeParaAlterar() {
		Especialidade especialidade = new Especialidade();
		especialidade.setCodigo(1);
		especialidade.setNome("Mamografia");

		return especialidade;
	}

	static void imprimirTodasEspecialidades(List<Especialidade> listaEspecialidades) {
		for (Especialidade especialidades : listaEspecialidades) {
			System.out.println("ID-> " + especialidades.getCodigo());
			System.out.println("Nome -> " + especialidades.getNome());

		}
	}

	static void imprimirEspecialidade(Especialidade especialidadeEncontrada) {
		System.out.println("ID-> " + especialidadeEncontrada.getCodigo());
		System.out.println("Nome -> " + especialidadeEncontrada.getNome());

	}

	// MEDICO
	static Medico criandoMedico(Especialidade especialidadeMedico) {
		Medico medico = new Medico();
		medico.setNome("João");
		medico.setEmail("joao@joao.com");
		medico.setDataNascimento(LocalDate.of(1972, Month.APRIL, 24));
		medico.setEndereco("Rua capitao Nº 124");
		medico.setEspecialidade(especialidadeMedico);

		return medico;

	}

	static Medico criandoMedicoParaAlterar(Especialidade especialidadeMedico) {
		Medico medico = new Medico();
		medico.setCodigo(1);
		medico.setNome("Ricardo");
		medico.setEmail("ricardo@ricardo.com");
		medico.setDataNascimento(LocalDate.of(1984, Month.SEPTEMBER, 23));
		medico.setEndereco("Rua rodrigo Nº 070");
		medico.setEspecialidade(especialidadeMedico);

		return medico;
	}

	static void imprimirTodosMedicos(List<Medico> listarTodosMedicos) {
		for (Medico medico : listarTodosMedicos) {
			System.out.println("ID -> " + medico.getCodigo());
			System.out.println("Nome -> " + medico.getNome());
			System.out.println("E-mail -> " + medico.getEmail());
			System.out.println("Endereço -> " + medico.getEndereco());
			System.out.println("Data-Nascimento -> " + medico.getDataNascimento());
			System.out.println("Ativo -> " + medico.isAtivo());
			System.out.println("Especialidade -> " + medico.getEspecialidade().getNome());

			System.out.println("\n\n\n\n\n");
		}
	}

	static void imprimirMedico(Medico medico) {
		System.out.println("ID -> " + medico.getCodigo());
		System.out.println("Nome -> " + medico.getNome());
		System.out.println("E-mail -> " + medico.getEmail());
		System.out.println("Endereço -> " + medico.getEndereco());
		System.out.println("Data-Nascimento -> " + medico.getDataNascimento());
		System.out.println("Ativo -> " + medico.isAtivo());
		System.out.println("Especialidade -> " + medico.getEspecialidade().getNome());

	}

	// PACIENTE
	static Paciente criandoPaciente() {
		Paciente paciente = new Paciente();
		paciente.setNome("Jorge");
		paciente.setEmail("jorge@jorge.com");
		paciente.setEndereco("Estrada esperança Nº234 - RJ-Valença");
		paciente.setDataNascimento(LocalDate.of(2000, Month.JANUARY, 9));

		return paciente;
	}

	static Paciente criandoPacienteParaAlterar() {
		Paciente paciente = new Paciente();
		paciente.setCodigo(1);
		paciente.setNome("Vitor ");
		paciente.setEmail("vitor@vitor.com");
		paciente.setEndereco("Estrada Dona Benta Nº001 - RJ-Volta Redonda");
		paciente.setDataNascimento(LocalDate.of(1990, Month.AUGUST, 10));

		return paciente;
	}

	static void imprimirTodosPacientes(List<Paciente> listaTodosPacientes) {
		for (Paciente paciente : listaTodosPacientes) {
			System.out.println("ID -> " + paciente.getCodigo());
			System.out.println("Nome -> " + paciente.getNome());
			System.out.println("E-mail -> " + paciente.getEmail());
			System.out.println("Endereço -> " + paciente.getEndereco());
			System.out.println("Data-Nascimento " + paciente.getDataNascimento());

			System.out.println("\n\n\n\n\n\n");
		}
	}

	static void imprimirPaciente(Paciente paciente) {
		System.out.println("ID -> " + paciente.getCodigo());
		System.out.println("Nome -> " + paciente.getNome());
		System.out.println("E-mail -> " + paciente.getEmail());
		System.out.println("Endereço -> " + paciente.getEndereco());
		System.out.println("Data-Nascimento " + paciente.getDataNascimento());

		System.out.println("\n\n\n\n\n\n");
	}

	// CONSULTA
	static Consulta criandoConsulta(Medico medico, Paciente paciente) {
		Consulta consulta = new Consulta();
		consulta.setDataEHora(LocalDateTime.of(2020, Month.OCTOBER, 6, 15, 30));
		consulta.setMedico(medico);
		consulta.setPaciente(paciente);

		return consulta;
	}

	static Consulta criandoConsultaAlterar(Medico medico, Paciente paciente) {
		Consulta consulta = new Consulta();
		consulta.setCodigo(1);
		consulta.setDataEHora(LocalDateTime.of(2020, Month.DECEMBER, 10, 9, 00));
		consulta.setMedico(medico);
		consulta.setPaciente(paciente);

		return consulta;
	}

	static void imprimirTodasConsultas(List<Consulta> listaConsultas) {
		for (Consulta consulta : listaConsultas) {
			System.out.println("ID -> " + consulta.getCodigo());
			System.out.println("Data e hora marcada -> " + consulta.getDataHora());
			System.out.println("Paciente -> " + consulta.getPaciente().getNome());
			System.out.println("Médico -> " + consulta.getMedico().getNome());
			System.out.println("Especialidade-> " + consulta.getMedico().getEspecialidade().getNome());
		}
	}

	static void imprimirConsulta(Consulta consulta) {
		System.out.println("ID -> " + consulta.getCodigo());
		System.out.println("Data e hora marcada -> " + consulta.getDataHora());
		System.out.println("Paciente -> " + consulta.getPaciente().getNome());
		System.out.println("Médico -> " + consulta.getMedico().getNome());
		System.out.println("Especialidade-> " + consulta.getMedico().getEspecialidade().getNome());
		
		System.out.println("\n\n\n\n\n\n\n");
	}

}
