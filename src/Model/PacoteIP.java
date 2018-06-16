package Model;


import java.io.Serializable;
import java.net.InetAddress;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mrgab
 */
public class PacoteIP implements Serializable{
    private short versao, comprimentoDoCabecalho, comprimentoPacote, identificacao, falgMaisFragmentos, flagNaoFragmentar, deslocamentoDoFragmento, TLL = 5,checkSum, opcoes; 
    private String tipoServico, protocolo;
    private InetAddress ipDestino, ipOrigem;
    private Object dados;

    public Object getDados() {
        return dados;
    }

    public void setDados(Object dados) {
        this.dados = dados;
    }
    
    public short getVersao() {
        return versao;
    }

    public void setVersao(short versao) {
        this.versao = versao;
    }

    public short getComprimentoDoCabecalho() {
        return comprimentoDoCabecalho;
    }

    public void setComprimentoDoCabecalho(short comprimentoDoCabecalho) {
        this.comprimentoDoCabecalho = comprimentoDoCabecalho;
    }

    public short getComprimentoPacote() {
        return comprimentoPacote;
    }

    public void setComprimentoPacote(short comprimentoPacote) {
        this.comprimentoPacote = comprimentoPacote;
    }

    public short getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(short identificacao) {
        this.identificacao = identificacao;
    }

    public short getFalgMaisFragmentos() {
        return falgMaisFragmentos;
    }

    public void setFalgMaisFragmentos(short falgMaisFragmentos) {
        this.falgMaisFragmentos = falgMaisFragmentos;
    }

    public short getFlagNaoFragmentar() {
        return flagNaoFragmentar;
    }

    public void setFlagNaoFragmentar(short flagNaoFragmentar) {
        this.flagNaoFragmentar = flagNaoFragmentar;
    }

    public short getDeslocamentoDoFragmento() {
        return deslocamentoDoFragmento;
    }

    public void setDeslocamentoDoFragmento(short deslocamentoDoFragmento) {
        this.deslocamentoDoFragmento = deslocamentoDoFragmento;
    }

    public short getTLL() {
        return TLL;
    }

    public void setTLL(short TLL) {
        this.TLL = TLL;
    }

    public short getCheckSum() {
        return checkSum;
    }

    public void setCheckSum(short checkSum) {
        this.checkSum = checkSum;
    }

    public short getOpcoes() {
        return opcoes;
    }

    public void setOpcoes(short opcoes) {
        this.opcoes = opcoes;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }

    public InetAddress getIpDestino() {
        return ipDestino;
    }

    public void setIpDestino(InetAddress ipDestino) {
        this.ipDestino = ipDestino;
    }

    public InetAddress getIpOrigem() {
        return ipOrigem;
    }

    public void setIpOrigem(InetAddress ipOrigem) {
        this.ipOrigem = ipOrigem;
    }
    
}
