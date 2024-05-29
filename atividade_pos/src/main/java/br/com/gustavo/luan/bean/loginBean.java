package br.com.gustavo.luan.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.gustavo.luan.domain.Usuario;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@ManagedBean(name = "MBLogin")
@ViewScoped
public class loginBean {
	@Getter @Setter	
	private Usuario usuario;
    

    // Método de Login
    public String login() {
        if("admin".equals(usuario.getUsuaio()) && "admin".equals(usuario.getSenha())) {
            return "home?faces-redirect=true"; // Sucesso: redirecionar para a página inicial
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login falhou", "Usuário ou senha incorretos"));
            return "login"; // Falha: permanecer na página de login
        }
    }
}
