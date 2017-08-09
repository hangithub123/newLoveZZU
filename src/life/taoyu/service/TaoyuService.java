package life.taoyu.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
<<<<<<< HEAD
=======

>>>>>>> origin/master
import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;

import life.taoyu.dao.Dao_taoyu;
import life.taoyu.entity.Cart;
import life.taoyu.entity.Comments_L1;
import life.taoyu.entity.Comments_L2;
import life.taoyu.entity.Goods;
import life.taoyu.entity.Order;
import life.taoyu.entity.OrderItems;
import life.taoyu.modeldriver.CGoods;
import life.taoyu.modeldriver.L1_Comments_Modeldriver;
import life.taoyu.modeldriver.L2_Comments_Modeldriver;
import life.taoyu.modeldriver.OrderAndItems;
import life.taoyu.modeldriver.OrderGoods;
import life.taoyu.modeldriver.Order_Ugoods;
import life.taoyu.modeldriver.UComments_L2;
import life.taoyu.modeldriver.Ucomments;
import life.taoyu.modeldriver.Ugoods;
import persionalCenter.dao.Dao;
import persionalCenter.entity.User;
import persionalCenter.entity.UserInfo;
import zzu.util.GetDate;

@Transactional
@Component(value = "taoyuService")

public class TaoyuService {

	@Resource(name = "user_Dao")
	private Dao dao;
	@Resource(name = "taoyuDao")
	private Dao_taoyu TDao;
	
	private GetDate date=new GetDate();


	// ����������Ʒ����
	public String savegoods(Goods goods) {
		
	boolean	Successful = false;
		String goods_id = null;
		Serializable	id = null;// ��ʼ��id
	String	sql = "from User where SessionID=?";
	String	values = goods.getSessionID();
		List<User> list = dao.query(sql, values);

		for (User user : list) {
			goods.setGdate(date.GetNowDate());
			goods.setGsearch(goods.getGtype() + goods.getGname() + goods.getGcampus() + goods.getGdescribe());

			goods.setGcomments(0);
			user.getSetgoods().add(goods);
			goods.setUser(user);
			id = this.dao.save(goods);
			goods_id = id.toString();
			Successful = true;
		}

		if (Successful) {// ���������ֶε�����
			sql = "from Goods where Goods_id=?";
			resetSearch(sql, Integer.parseInt(goods_id));
		}
		return goods_id;
		 }
	

	// ɾ����Ʒ
	public boolean deletegoods(String goodsID) {
		 
		boolean	Successful =false;
		Integer id = Integer.valueOf(goodsID);
		System.out.println("תΪInteger:" + id);

	String	sql = "from Goods where Goods_id=?";
		List<Goods> list = this.dao.query(sql, id);

		for (Goods goods : list) {

			dao.delete(goods);
			Successful = true;
		}

		return Successful;
		 }
	

	// �����ѯ��Ʒ
	public List<Ugoods> query(String action, int num, String sql) {
		

		List<Ugoods> uglist = new ArrayList<Ugoods>();

		// List<Goods> goodslist=dao.query(sql, values);
		List<Goods> goodslist = TDao.hqlquery(sql, action, num);
		for (Goods goods : goodslist) {
			Ugoods ug = new Ugoods();
			sql = "from UserInfo where ul_id=?";
		String	values = goods.getUser().getUid().toString();

			List<UserInfo> userinfo = dao.query(sql, values);
			for (UserInfo userInfo2 : userinfo) {

				ug.setUserinfo(userInfo2);
				ug.setGoods(goods);

			}
			uglist.add(ug);

		}
		return uglist;
		 }
	

	// ����Ա��ѯ��Ʒ��ģ������search�ֶ�
	public List<Ugoods> AdminQueryGoods(String sql) {
		List<Ugoods> uglist = new ArrayList<Ugoods>();
		List<Goods> goodslist = TDao.adminhqlquery(sql);
		for (Goods goods : goodslist) {
			Ugoods ug = new Ugoods();
			sql = "from UserInfo where ul_id=?";
		String	values = goods.getUser().getUid().toString();

			List<UserInfo> userinfo = dao.query(sql, values);
			for (UserInfo userInfo2 : userinfo) {

				ug.setUserinfo(userInfo2);
				ug.setGoods(goods);

			}
			uglist.add(ug);

		}
		return uglist;

	}

	// ����ͼƬ��
	public String[] getImageName(String SessionID, String goods_id) {
		 
		String[] str = new String[10];

		String Account = null;
		String oldimageurl = null;
		String sql = "from User where SessionID=?";
		String values = SessionID;
		List<User> list2 = dao.query(sql, values);

		if (!list2.isEmpty()) {
			for (User user : list2) {
				Account = user.getAccount();

			}
			sql = "from Goods where Goods_id=?";
			values = goods_id;
			Integer integer = Integer.valueOf(goods_id);
			List<Goods> list3 = dao.query(sql, integer);

			for (Goods goods : list3) {
				oldimageurl = goods.getGimage();

			}

			str[0] = Account;
			str[1] = oldimageurl;
		}
		return str;
		 }
	

	// ������Ʒ��Ϣ
	public void updateGoods(Goods goods) {
		 
		boolean Successful=false;
		System.out.println("��ʼ������Ʒ��Ϣ");
		String sql = "from Goods where Goods_id=?";
		Integer integer = Integer.valueOf(goods.getGoods_id());

		List<Goods> list = dao.query(sql, integer);
		if (list.size() == 1) {
			for (Goods querygoods2 : list) {
				if (goods.getGtype() != null && !goods.getGtype().equals("")) {
					querygoods2.setGtype(goods.getGtype());
				}
				if (goods.getGname() != null && !goods.getGname().equals("")) {
					querygoods2.setGname(goods.getGname());
				}
				if (goods.getGcampus() != null && !goods.getGcampus().equals("")) {
					querygoods2.setGcampus(goods.getGcampus());
				}
				if (goods.getGdescribe() != null && !goods.getGdescribe().equals("")) {
					querygoods2.setGdescribe(goods.getGdescribe());
				}
				if (goods.getGprice() != null && !goods.getGprice().equals("")) {
					querygoods2.setGprice(goods.getGprice());
				}
				if (goods.getGimage() != null && !goods.getGimage().equals("")) {
					querygoods2.setGimage(goods.getGimage());
				}
				if (goods.getGdate() != null && !goods.getGdate().equals("")) {
					querygoods2.setGdate(goods.getGdate());
				}

				if (goods.getGcomments() != null && !goods.getGcomments().equals("")) {
					querygoods2.setGcomments(goods.getGcomments());
				}

				this.dao.update(querygoods2);
				Successful = true;

				System.out.println("������Ʒ��Ϣ�ɹ�");

			}
		}
		if (Successful)
			resetSearch(sql, integer);
		 }
	

	// ������Ʒ����search�ֶ�����
	public boolean resetSearch(String sql, Integer integer) {
		boolean Successful = false;
		List<Goods> list = dao.query(sql, integer);
		for (Goods goods : list) {
			goods.setGsearch(goods.getGoods_id() + goods.getGcampus() + goods.getGname() + goods.getGtype()
					+ goods.getGdescribe());
			this.dao.update(goods);
			Successful = true;
			System.out.println("������Ʒ����search�ֶ����ݳɹ�!");
		}
		return Successful;
	}

	//// �����Ʒ�����ﳵ
	public boolean AddGoodsToCart(String[] cartinfo) { // cart[0]=SessionID;cart[1]=goods_id;cart[2]=count+"";
		
		boolean Successful = false;
		String sql = "from User where SessionID=?";
		String values = cartinfo[0];
		List<User> list2 = dao.query(sql, values);
		for (User user : list2) {
			Cart cart = new Cart();
			cart.setGoods_id(Integer.valueOf(cartinfo[1]));
			cart.setCount(Integer.parseInt(cartinfo[2]));
			user.getSetcart().add(cart);
			cart.setUser(user);
			this.dao.save(cart);
			System.out.println("��Ʒ��ӹ��ﳵ�ɹ�");
			Successful = true;
		}

		return Successful;
		 }
	

	// ��ѯ���ﳵ����Ʒ
	public List<CGoods> queryCart(String[] cartinfo) {
		
	String 	sql = "from User where SessionID=?";
		String values = cartinfo[0];
		List<User> list2 = dao.query(sql, values);
		Integer I = null;
		for (User user : list2) {
			I = user.getUid();

		}
		sql = "from Cart where UCart_id=?";
		List<Cart> list3 = dao.query(sql, I);
		List<CGoods> cglist = new ArrayList<CGoods>();

		for (int j = 0; j < list3.size(); j++) {
			CGoods cgoods = new CGoods();
			sql = "from Goods where Goods_id=?";
			List<Goods> list4 = dao.query(sql, list3.get(j).getGoods_id());
			System.out.println("��һ��list4:" + j + "," + list4);
			cgoods.setCount(list3.get(j).getCount() + "");
			for (int i = 0; i < list4.size(); i++) {

				cgoods.setGoods(list4.get(i));

				cglist.add(cgoods);
				System.out.println("�ڶ���");

			}
		}
		return cglist;
		 }
	
//���Ҳ�ѯ�Լ��ķ�����Ʒ
	public List<Goods> QueryPublishedGoods(String SessionID){
		
		List<Goods> glist = null;
		String sql="from User where SessionID=?";
		List<User> user=dao.query(sql, SessionID);
		for (User user2 : user) {
			sql="from Goods where UG_id=?";
			 glist=dao.query(sql, user2.getUid());
			
		}
		
		if(glist.size()==0){System.out.println("δ�鵽�ѷ�����Ʒ");}
		Collections.reverse(glist);
		
		return glist;
		 }
	
// ɾ���ѷ�������Ʒ
	public boolean deletePublishedGoods(String goods_id){
		 
		boolean Successful=false;
		String sql="from Goods where Goods_id=?";
		Integer id=Integer.valueOf(goods_id);
		List<Goods> goods=dao.query(sql, id);
		for (Goods goods2 : goods) {
			dao.delete(goods2);
			Successful=true;	
			}
			return Successful;
		 }
	
	// ɾ�����ﳵ����Ʒ
	public boolean DeleteGoodsFromCart(String[] cartinfo) {
		 
		boolean Successful = false;
		String sql = "from Cart where goods_id=?";

		List<Cart> list2 = dao.query(sql, Integer.valueOf(cartinfo[1]));
		for (Cart cart : list2) {
			this.dao.delete(cart);

			Successful = true;
		}
		return Successful;
	}

	// ���涩��
	public boolean savaorder(OrderAndItems orderdata) {
		  
		boolean Successful = false;
		Serializable	id = null;
		Integer total=0;
		List<OrderItems> itemsprice = orderdata.getOrderItemsData();
		for (OrderItems orderItems : itemsprice) {
			int count=orderItems.getCount();
		String	sql="from Goods where Goods_id=?";
			List<Goods> goods=dao.query(sql, orderItems.getGoods_id());
			String Gprice=goods.get(0).getGprice();
			count=Integer.valueOf(count);
			int p=Integer.valueOf(Gprice);
			total+=(p*count);
			System.out.println(p+"*"+count);
			System.out.println("total:"+total);
		}
		System.out.println("total:"+total);
		String sql = "from User where SessionID=?";
		String values = orderdata.getSessionID();
		List<User> list = dao.query(sql, values);
		if (list.size() == 0) {
			System.out.println("���涩�����û�û�ҵ�");
			return false;
		}
		
		// ����û����������涩����Ϣ
		for (User user : list) {
			Order order = orderdata.getOrderData();
			order.setOrder_date(date.GetNowDate());
			order.setOrder_status("������");
			order.setTotal(total.toString());
			order.setUser(user);
			user.getSetorder().add(order);
				id = this.dao.save(order);
			System.out.println("���涩���ɹ�");
		}
		sql = "from Order where order_id=?";

		Integer id1 = Integer.valueOf(id + "");
		List<Order> orderlist = dao.query(sql, id1);

		List<OrderItems> items = orderdata.getOrderItemsData();
		for (OrderItems orderItems : items) {
			
			orderItems.setOrder(orderlist.get(0));
			this.dao.save(orderItems);
			System.out.println("���涩����ɹ�");
			Successful = true;

		}
		return Successful;
		 }
	

// ��ѯ������ж���
	public List<Order_Ugoods> queryorder(OrderAndItems OAI) {
		 
		
		String sql = "from User where SessionID=?";
		String values = OAI.getSessionID();
		List<User> list = dao.query(sql, values);
		Integer uid = list.get(0).getUid();
		List<Order_Ugoods> listOUG = new ArrayList<Order_Ugoods>();
		// Order_Ugoods OUG=new Order_Ugoods();//�洢 ��������Ʒ��������Ϣ�Ķ���

		// Ugoods ug=new Ugoods();
		// ���һ�Ѷ���
		sql = "from Order where UO_id=? order by id desc";
		List<Order> list2 = dao.query(sql, uid);
		for (int i = 0; i < list2.size(); i++) {
			List<Ugoods> listUG = new ArrayList<Ugoods>();// �洢��Ʒ��������Ϣ����ļ���
			Order_Ugoods OUG = new Order_Ugoods();// �洢��Ʒ��������Ϣ����Ͷ�������Ķ���

			OUG.setOrderdata(list2.get(i));// �����������Order_Ugoods��
			// ���һ�Ѷ�����
			sql = "from OrderItems where OOItems_id=?";
			List<OrderItems> list3 = dao.query(sql, list2.get(i).getOrder_id());
			// ����Ʒ��Ϣ

			for (int j = 0; j < list3.size(); j++) {// �����Ʒ���û���Ϣ���󣬴���ug������
				Ugoods ug = new Ugoods();
				ug.setCount(list3.get(j).getCount());
				sql = "from Goods where goods_id=?";
				List<Goods> list4 = dao.query(sql, list3.get(j).getGoods_id());
				for (Goods goods : list4) {
					String gprice=goods.getGprice();
					if(gprice==null){gprice="0";}
					int   total=Integer.valueOf(gprice) * list3.get(j).getCount();
					ug.setTotal(total);
					ug.setGoods(goods);
				}
				
				// ��������Ϣ
				for (Goods goods : list4) {
					sql = "from UserInfo where ul_id=?";
					List<UserInfo> list5 = dao.query(sql, goods.getUser().getUid());
					UserInfo userinfo = list5.get(0);

					ug.setUserinfo(userinfo);
					listUG.add(ug);// ����Ʒ��������Ϣ�������list����
				}
			}
			OUG.setUgoods(listUG);// Ugoods�������Order_Ugoods��
			listOUG.add(OUG);// OUG�������listOUG������

		}
		return listOUG;
		 }
	

// �޸Ķ���״̬
	public boolean updateOrderStatus(Order order) {
		 
		boolean Successful = false;
		String sql = "from Order where order_id=?";
		Integer id=order.getOrder_id();
		List<Order> orderlist=dao.query(sql, id);
		if(orderlist.size()==0){System.out.println("����Ϊ������"); return false;}
		for (Order o : orderlist) {
			if(order.getTotal()!=null && !order.getTotal().isEmpty())
				o.setTotal(order.getTotal());
			if(order.getOrder_status()!=null && !order.getOrder_status().isEmpty())
			o.setOrder_status(order.getOrder_status());
			
			dao.update(o);
			Successful=true;
		}
		return Successful;
		 }
	
//ɾ������
	public boolean deleteOrder(Integer id){
		
	boolean	Successful=false;
      String    sql = "from Order where order_id=?";		
		List<Order> order=dao.query(sql, id);
		if(order==null){System.out.println("����δ������"); return false;}
		
		dao.delete(order.get(0));
		Successful=true;
		return Successful;
		 }
	
//��ѯ���Ҷ���
	public List<OrderGoods> querySellerOrder(String SessionID){
		 
		List<OrderGoods> OGlist=new ArrayList<OrderGoods>();
	String	sql="from User where SessionID=?";
		List<User> user=dao.query(sql, SessionID);
		if(user.size()==0){System.out.println("��ѯ�����Ʒ����,�û�δ������");return null;}
		Set<Goods> goods= user.get(0).getSetgoods();
		for (Goods g : goods) {
			
		sql="from OrderItems where goods_id=?";
		List<OrderItems> oi=dao.query(sql, g.getGoods_id());
		
				for (OrderItems orderItems : oi) {
					int count=orderItems.getCount();
					int total=orderItems.getCount()*(Integer.valueOf(g.getGprice()));
					OrderGoods og=new OrderGoods();
					Order order=orderItems.getOrder();
					order.setTotal(total+"");
							og.setOrder(order);
							og.setGoods(g);
							og.setCount(count);
							OGlist.add(og);
				}
		
		}System.out.println(OGlist);
		return OGlist;
		 }
	
	// ��ѯһ������
	public <S> List<Ucomments> querycomments(String sql, S values, int num) {
		
		List<Ucomments> uclist = new ArrayList<Ucomments>();

		List<Comments_L1> commentslist = TDao.hqlquery(sql, values, num);
		for (Comments_L1 comments_L1 : commentslist) {
			Ucomments uc = new Ucomments();
			sql = "from User where account=?";
			values = (S) comments_L1.getAccount();
			List<User> user = dao.query(sql, values);
			System.out.println(user.toString());
			for (User user2 : user) {
				sql = "from UserInfo where ul_id=?";
				values = (S) user2.getUid().toString();

				List<UserInfo> userinfo = dao.query(sql, values);
				for (UserInfo userInfo2 : userinfo) {
					uc.setUserinfo(userInfo2);
					uc.setComments_L1(comments_L1);
					uclist.add(uc);
					System.out.println("uc���");
				}
			}
		}
		return uclist;

	}

	// �����û�һ��������Ϣ�����������ۺ��û���Ϣ��
	public Serializable postcomments(L1_Comments_Modeldriver CMD) {
		 
		Serializable	id=null;
		String sql = "from User where SessionID=?";
	String	values = CMD.getSessionID();
		List<User> user = dao.query(sql, values);
		if (user.size() == 0) {
			System.err.println("SessionID����");
			return null;
		}
		String account = user.get(0).getAccount();

		sql = CMD.getSql();
		values = CMD.getValues();
		Integer i = new Integer(values);

		List<Goods> goods = dao.query(sql, i);

		for (Goods g : goods) {

			Comments_L1 CL1 = new Comments_L1();
			CL1.setComments(CMD.getComments());
			CL1.setAccount(account);
			CL1.setCdate(date.GetNowDate());
			g.getSetcomments_L1().add(CL1);
			CL1.setCgoods(g);
			// ����������
			g.setGcomments(g.getGcomments() + 1);
			System.out.println("����������");

			id = this.dao.save(CL1);
			updateGoods(g);
			System.out.println("id:" + id);
		}

		// TaoyuService t = new TaoyuService();
		// sql = "from Comments_L1 where L1_Cid=?";
		// Integer v = new Integer((int) id);
		// System.out.println(v);
		// uclist = t.querycomments(sql, v, 0);

		return id;
		 }
	

	// �����������
	public boolean postcommentsL2(L2_Comments_Modeldriver CMD2) {
		
		boolean Successful = false;
	String	sql = "from User where SessionID=?";
	String	values = CMD2.getSessionID();
		List<User> user = dao.query(sql, values);
		if (user.size() == 1) {

			if (CMD2.getL1_Cid() != null && !CMD2.getL1_Cid().isEmpty()) {
				// ����������һ�����۲���
				List<Comments_L1> comments_l1 = dao.query(CMD2.getSql(), CMD2.getValues());
				for (Comments_L1 comments : comments_l1) {
					// �������������Ϣ
					if (CMD2.getComments() != null && !CMD2.getComments().isEmpty()) {
						comments.setNum_replies(comments.getNum_replies() + 1);
						Comments_L2 CL2 = new Comments_L2();
						CL2.setComments(CMD2.getComments());
						CL2.setCdate(date.GetNowDate());
						CL2.setCommented_id("L1" + "ZZU" + comments.getL1_Cid() + "");
						CL2.setAccount(user.get(0).getAccount());
						CL2.setComments_l1(comments);
						comments.getSetcomments_L2().add(CL2);
						this.dao.save(CL2);
						System.out.println("�������浽�������۱�ɹ�,һ�����۵Ļظ���+1");

					} else if (CMD2.getThumbNum() != null && !CMD2.getThumbNum().isEmpty()) {

						// ���޴������ݿ�
						if (CMD2.getThumbNum() != null && CMD2.getThumbNum().equals("1")) {
							comments.setNum_thumb(comments.getNum_thumb() + 1);
							System.out.println("һ�����۵�����+1");
						} else if (CMD2.getThumbNum().equals("0")) {
							comments.setNum_thumb(comments.getNum_thumb() - 1);
						}

					} else {
						System.out.println("����Ϊ�գ��ҵ��ޱ�ʶΪ��");
					}
					this.dao.update(comments);

					Successful = true;
				}
			} else if (CMD2.getL2_Cid() != null && !CMD2.getL2_Cid().isEmpty()) {
				// �����������������۲���
				List<Comments_L2> comments_l2 = dao.query(CMD2.getSql(), CMD2.getValues());
				for (Comments_L2 comments2 : comments_l2) {
					// �������������Ϣ
					if (CMD2.getComments() != null && !CMD2.getComments().isEmpty()) {
						// �������ݳ���15���ַ��ͽ�ȡǰ15���ַ���
						String strComments = null;
						if (comments2.getComments().length() > 15) {
							strComments = comments2.getComments().substring(0, 15);
						} else {
							strComments = comments2.getComments();
						}
						Comments_L2 CL2 = new Comments_L2();
						CL2.setComments(CMD2.getComments() + "@:" + strComments);
						CL2.setCdate(date.GetNowDate());
						CL2.setAccount(user.get(0).getAccount());
						CL2.setCommented_id("L2ZZU" + comments2.getL2_Cid() + "");
						CL2.setComments_l1(comments2.getComments_l1());

						this.dao.save(CL2);
						comments2.setNum_replies(comments2.getNum_replies() + 1);
						System.out.println("�������۶������۵�����,�����۵Ķ������ۻظ���+1");
					} else {

						// ���޴������ݿ�
						if (CMD2.getThumbNum() != null && CMD2.getThumbNum().equals("1")) {
							comments2.setNum_thumb(comments2.getNum_thumb() + 1);
							System.out.println("�������۵��޳ɹ�");
						} else if (CMD2.getThumbNum() != null && CMD2.getThumbNum().equals("0")) {
							comments2.setNum_thumb(comments2.getNum_thumb() - 1);
							System.out.println("��������ȡ�����޳ɹ�");
						}

					}
					this.dao.update(comments2);

					Successful = true;
				}
			}

		} else {
			System.out.println("�����������ʧ�ܣ��û�������");
		}
		return Successful;
		 }
	

	// ��ѯ��������
	public List<UComments_L2> querycomments(L2_Comments_Modeldriver CMD2) {
		List<UComments_L2> uc2list = new ArrayList<UComments_L2>();
		// ����������۶���
		List<Comments_L2> CL2 = dao.query(CMD2.getSql(), CMD2.getValues());
		for (Comments_L2 comments_L2 : CL2) {
			UComments_L2 uc2 = new UComments_L2();
			// ����û�����
		String	sql = "from User where account=?";
			List<User> userlist = dao.query(sql, comments_L2.getAccount());
			sql = "from UserInfo where ul_id=?";
			List<UserInfo> userinfo = dao.query(sql, userlist.get(0).getUid());
			uc2.setComments_l2(comments_L2);
			uc2.setUserinfo(userinfo.get(0));
			uc2list.add(uc2);
		}
		return uc2list;

	}

}
