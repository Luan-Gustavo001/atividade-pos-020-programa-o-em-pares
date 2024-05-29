package br.com.gustavo.luan.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.gustavo.luan.domain.Usuario;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Named("MBLogin")
public class LoginBean {
	
    
	public String Login(Usuario usuarioLogin) {
		Usuario usuario = new Usuario();
			Boolean usuarioIgual, senhaIgual;
			usuarioIgual = usuario.getUsuario().equals(usuarioLogin.getUsuario());
			senhaIgual = usuario.getSenha().equals(usuarioLogin.getSenha());
			
			if(usuarioIgual && senhaIgual) {
				return "home?faces-redirect=true"; //Sucesso: redirecionar para a página inicial
			}else {
				FacesContext.getCurrentInstance().addMessage(null,
		                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login falhou", "Usuário ou senha incorretos"));
		            return "login"; // Falha: permanecer na página de login
			}
	}
	
}
