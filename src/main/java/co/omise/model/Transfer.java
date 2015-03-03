package main.java.co.omise.model;

import java.io.IOException;
import java.util.HashMap;

import main.java.co.omise.exeption.OmiseAPIException;
import main.java.co.omise.exeption.OmiseKeyUnsetException;
import main.java.co.omise.exeption.OmiseUnknownException;
import main.java.co.omise.net.APIResource;

public class Transfer extends APIResource {
	protected static final String ENDPOINT = "transfers";
	
	protected String object = null;
	protected String id = null;
	protected Boolean livemode = null;
	protected String location = null;
	protected Boolean sent = false;
	protected Boolean paid = false;
	protected Integer amount = null;
	protected String currency = null;
	protected String failure_code = null;
	protected String failure_message = null;
	protected String transaction = null;
	protected String created = null;
	
	public String getObject() {
		return object;
	}
	public String getId() {
		return id;
	}
	public Boolean getLivemode() {
		return livemode;
	}
	public String getLocation() {
		return location;
	}
	public Boolean getSent() {
		return sent;
	}
	public Boolean getPaid() {
		return paid;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public String getFailureCode() {
		return failure_code;
	}
	public String getFailureMessage() {
		return failure_message;
	}
	public String getTransaction() {
		return transaction;
	}
	public String getCreated() {
		return created;
	}
	
	/**
	 * @return
	 * @throws OmiseAPIException
	 * @throws OmiseKeyUnsetException
	 * @throws OmiseUnknownException
	 * @throws IOException
	 */
	public static Transfers retrieve() throws OmiseAPIException, OmiseKeyUnsetException, OmiseUnknownException, IOException {
		return (Transfers)request(OmiseURL.API, ENDPOINT, RequestMethod.GET, null, Transfers.class);
	}
	
	/**
	 * @param id {@code null}を渡してはならない
	 * @return
	 * @throws OmiseAPIException
	 * @throws OmiseKeyUnsetException
	 * @throws OmiseUnknownException
	 * @throws IOException
	 */
	public static Transfer retrieve(String id) throws OmiseAPIException, OmiseKeyUnsetException, OmiseUnknownException, IOException {
		return (Transfer)request(OmiseURL.API, String.format("%s/%s", ENDPOINT, id), RequestMethod.GET, null, Transfer.class);
	}
	
	/**
	 * @param params {@code null}もしくは0要素のHashMapを渡してはならない
	 * @return
	 * @throws OmiseAPIException
	 * @throws OmiseKeyUnsetException
	 * @throws OmiseUnknownException
	 * @throws IOException
	 */
	public static Transfer create(HashMap<String, Object> params) throws OmiseAPIException, OmiseKeyUnsetException, OmiseUnknownException, IOException {
		return (Transfer)request(OmiseURL.API, ENDPOINT, RequestMethod.POST, params, Transfer.class);
	}
	
	/**
	 * @return
	 * @throws OmiseAPIException
	 * @throws OmiseKeyUnsetException
	 * @throws OmiseUnknownException
	 * @throws IOException
	 */
	public DeleteTransfer destroy() throws OmiseAPIException, OmiseKeyUnsetException, OmiseUnknownException, IOException {
		return (DeleteTransfer)request(OmiseURL.API, String.format("%s/%s", ENDPOINT, id), RequestMethod.DELETE, null, DeleteTransfer.class);
	}
	
	/**
	 * saveを実行する前にこのインスタンスのamountを更新し、呼び出す必要がある
	 * @return
	 * @throws OmiseAPIException
	 * @throws OmiseKeyUnsetException
	 * @throws OmiseUnknownException
	 * @throws IOException
	 */
	@SuppressWarnings("serial")
	public Transfer save() throws OmiseAPIException, OmiseKeyUnsetException, OmiseUnknownException, IOException {
		return update(new HashMap<String, Object>() {
				{put("amount", amount);}
			});
	}
	
	/**
	 * @param params {@code null}もしくは0要素のHashMapを渡してはならない
	 * @return
	 * @throws OmiseAPIException
	 * @throws OmiseKeyUnsetException
	 * @throws OmiseUnknownException
	 * @throws IOException
	 */
	private Transfer update(HashMap<String, Object> params) throws OmiseAPIException, OmiseKeyUnsetException, OmiseUnknownException, IOException {
		return  updateMyself((Transfer)request(OmiseURL.API, String.format("%s/%s", ENDPOINT, id), RequestMethod.PATCH, params, Transfer.class));
	}
	
	/**
	 * 更新系の処理の場合に必ず呼び、自分自身のインスタンスの内容を最新に更新する。
	 * @param transfer
	 * @return
	 */
	private Transfer updateMyself(Transfer transfer) {
		this.object = transfer.getObject();
		this.id = transfer.getId();
		this.livemode = transfer.getLivemode();
		this.location = transfer.getLocation();
		this.sent = transfer.getSent();
		this.paid = transfer.getPaid();
		this.amount = transfer.getAmount();
		this.currency = transfer.getCurrency();
		this.failure_code = transfer.getFailureCode();
		this.failure_message = transfer.getFailureMessage();
		this.transaction = transfer.getTransaction();
		this.created = transfer.getCreated();
		
		return this;
	}
}
