package br.com.boaentrega.queues.senders;

import br.com.boaentrega.queues.messages.AsyncOperationMessage;

public interface OperationQueueSender {

    void sendMessage(AsyncOperationMessage asyncOperationMessage);

}
