package br.com.cbobio.cbgames.service.interceptor;
import br.com.cbobio.cbgames.service.exceptions.AcessoNegadoException;
import br.com.cbobio.cbgames.service.exceptions.EntidadeNaoLocalizadaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.nio.file.AccessDeniedException;

@ControllerAdvice
public class APIExceptionHandler {
    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<Object> handleMaxUploadSizeExceeded(MaxUploadSizeExceededException ex, WebRequest request) {
        String mensagem = "O arquivo enviado é muito grande. O limite individual é de 10MB e o total da requisição é 20MB.";

        DefaultAPIResponse<Object> errorResponse = DefaultAPIResponse.error(mensagem);

        return ResponseEntity
                .status(HttpStatus.PAYLOAD_TOO_LARGE) // Status 413
                .body(errorResponse);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Object> handleAccessDenied(AccessDeniedException ex, WebRequest request) {
        DefaultAPIResponse<Object> errorResponse = DefaultAPIResponse.error("Acesso negado: Você não possui permissão para realizar esta operação.");

        return ResponseEntity
                .status(HttpStatus.FORBIDDEN) // 403 é o status correto para falta de permissão
                .body(errorResponse);
    }

    @ExceptionHandler(AcessoNegadoException.class)
    public ResponseEntity<Object> handleNotFound(AcessoNegadoException ex, WebRequest request) {
        DefaultAPIResponse<Object> errorResponse = DefaultAPIResponse.error(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(EntidadeNaoLocalizadaException.class)
    public ResponseEntity<Object> handleNotFound(EntidadeNaoLocalizadaException ex, WebRequest request) {
        DefaultAPIResponse<Object> errorResponse = DefaultAPIResponse.error(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleRuntime(RuntimeException ex, WebRequest request) {
        DefaultAPIResponse<Object> errorResponse = DefaultAPIResponse.error(ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, WebRequest request) {
        StringBuilder errorMsg = new StringBuilder();
        errorMsg.append("Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.");

        for (ObjectError erro : ex.getBindingResult().getAllErrors()) {
            if (erro instanceof FieldError) {
                String field = ((FieldError) erro).getField();
                String mensagem = messageSource.getMessage(erro, LocaleContextHolder.getLocale());
                errorMsg.append(field + ": " + mensagem);
            } else {
                String nome = erro.getObjectName();
                String mensagem = erro.getDefaultMessage();
                errorMsg.append(nome + ": " + mensagem);
            }
        }

        DefaultAPIResponse<Object> errorResponse = DefaultAPIResponse.error(errorMsg.toString());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);
    }
}