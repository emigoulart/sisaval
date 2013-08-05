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
		   //Quando a porta utilizada n�o � a padr�o (gmail = 465)
		   email.setSmtpPort(465);
		   //Adicione os destinat�rios
		   email.addTo("aline.carlos@gmail.com", "Aline");
		   //Configure o seu email do qual enviar�
		   email.setFrom("avaliacaogrupof@gmail.com", "Avalia��o - Grupo F");
		   //Adicione um assunto
		   email.setSubject("Avalia��o Realizada!");
		   //Adicione a mensagem do email
		   email.setMsg(this.preparaCorpo(avaliacao));
		   //Para autenticar no servidor � necess�rio chamar os dois m�todos abaixo
		   email.setSSLOnConnect(true);
		   email.setAuthentication("avaliacaogrupof", "102030qwe");
		   email.send();
		   
		}
	private String preparaCorpo(Avaliacao avaliacao){
		StringBuilder conteudo = new StringBuilder();
		String separador = System.getProperty("line.separator");  
		
		conteudo.append("Agradecemos a sua participa��o na avalia��o.");
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
