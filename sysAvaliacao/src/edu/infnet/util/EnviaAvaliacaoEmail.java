package edu.infnet.util;

import java.util.Iterator;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import edu.infnet.model.Avaliacao;
import edu.infnet.model.AvaliacaoRespostas;

public class EnviaAvaliacaoEmail {
	public void sendEmail(Avaliacao avaliacao) throws EmailException {
	    
		   SimpleEmail email = new SimpleEmail();
		   email.setHostName("smtp.gmail.com");
		   //Quando a porta utilizada não é a padrão (gmail = 465)
		   email.setSmtpPort(465);
		   
		   //Adicione os destinatários
		   email.addTo(avaliacao.getAluno().getEmail(), avaliacao.getAluno().getNome());

		   email.setFrom("avaliacaogrupof@gmail.com", "Avaliação - Grupo F");

		   email.setSubject("Avaliação Realizada!");
		   email.setMsg(this.preparaCorpo(avaliacao));
		   
		   //Para autenticar no servidor é necessário chamar os dois métodos abaixo
		   email.setSSLOnConnect(true);
		   email.setAuthentication("avaliacaogrupof", "102030qwe");
		   email.send();
		   
		}
	private String preparaCorpo(Avaliacao avaliacao){
		StringBuilder conteudo = new StringBuilder();
		String separador = System.getProperty("line.separator");  
		
		conteudo.append("Agradecemos a sua participação na avaliação.");
		conteudo.append(separador);
		conteudo.append(separador);
		conteudo.append("Disciplina: ");
	   conteudo.append(avaliacao.getDisciplina().getDisDescricao());
		conteudo.append(separador);
		conteudo.append(separador);
		Iterator<AvaliacaoRespostas> respostas = avaliacao.getAvaliacaorespostas().iterator();
		AvaliacaoRespostas resposta;
		int nroResposta;
		String descricaoResposta;
		while(respostas.hasNext()){
			resposta = respostas.next();
			conteudo.append(resposta.getQuestao().getQstQuestao());
			conteudo.append(" Resposta: ");
			nroResposta = resposta.getResposta();
			switch (nroResposta) {
			case 1:
				descricaoResposta ="Concordo Totalmente";
				break;
			case 2:
				descricaoResposta ="Concordo";
				break;
			case 3:
				descricaoResposta ="Não Concordo nem Discordo";
				break;
			case 4:
				descricaoResposta ="Discordo";
				break;
			case 5:
				descricaoResposta ="Discordo Totalmente";
				break;
			case 6:
				descricaoResposta ="Não sei avaliar";
				break;
			default:
				descricaoResposta = "Questão não resposta";
			}
			
			conteudo.append(descricaoResposta);
			conteudo.append(separador);
		}
		conteudo.append(separador);
		conteudo.append("Observação: ");
		conteudo.append(avaliacao.getObservacao());
		
		return conteudo.toString();
	}
}
