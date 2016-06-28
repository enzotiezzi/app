package br.com.zelar.zellarempresas.Http;

/**
 * Created by enzo on 30/05/2016.
 */
public interface ICallback
{
    void onRequestEnd(int statusCode, Throwable t, String response);
}
