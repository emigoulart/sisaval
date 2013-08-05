package edu.infnet.util;

import java.util.Iterator;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import edu.infnet.model.Avaliacao;
import edu.infnet.model.AvaliacaoRespostas;

public class EnviaAvaliacaoEmail {
	public void sendEmail(Avaliacao avaliacao) throws EmailException {
	    
		   SimpleEmail email = new SimpleEmail();
		   //Utilize o hostname do seu provedor de email
		   //System.out.println("alterando hostname...");
		   email.setHostName("smtp.gmail.com");
		   //Quando a porta utilizada não é a padrão (gmail = 465)
		   email.setSmtpPort(465);
		   //Adicione os destinatários
		   email.addTo("aline.carlos@gmail.com", "Aline");
		   //Configure o seu email do qual enviará
		   email.setFrom("avaliacaogrupof@gmail.com", "Avaliação - Grupo F");
		   //Adicione um assunto
		   email.setSubject("Avaliação Realizada!");
		   //Adicione a mensagem do email
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
		conteudo.append("Disciplina:  ");
		conteudo.append(avaliacao.getTurmaaluno().getTurma().getDisciplina().getDisDescricao());
		conteudo.append(separador);
		Iterator<AvaliacaoRespostas> respostas = avaliacao.getAvaliacaorespostas().iterator();
		AvaliacaoRespostas resposta;
		while(respostas.hasNext()){
			resposta = respostas.next();
			conteudo.append(resposta.getQuestao().getQstQuestao());
			conteudo.append(resposta.getResposta());
			conteudo.append(separador);
		}
		
		
		return conteudo.toString();
	}
}
