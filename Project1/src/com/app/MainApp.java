package com.app;

import java.util.List;
import java.util.Scanner;

import com.service.BoardService;
import com.service.BoardServiceDAO;
import com.service.MemberService;
import com.service.MemberServiceDAO;
import com.service.OrderService;
import com.service.OrderServiceDAO;
import com.service.ProductService;
import com.service.ProductServiceDAO;
import com.vo.Board;
import com.vo.Member;
import com.vo.Order;
import com.vo.Product;

public class MainApp {
	Scanner scn = new Scanner(System.in);

	MemberService msc = new MemberServiceDAO();
	BoardService bsc = new BoardServiceDAO();
	ProductService psc = new ProductServiceDAO();
	OrderService osc = new OrderServiceDAO();

	String admin; // 권한
	String user; // 로그인 아이디

	public void execute() {
		String id;
		String pw;
		String name;
		String phone;
		String email;
		int menu;

		boolean run = true;
		while (run) {
			System.out.println("-------------------------------------------------");
			System.out.println("1.로그인 2.회원가입 3.아이디 찾기 4.비밀번호 찾기 5.종료");
			System.out.print("선택>> ");

			menu = menuCheck(scn.nextLine());

			if (menu == 0) {
				continue;
			}

			switch (menu) {
			case 1:
				System.out.print("아이디>> ");
				id = scn.nextLine();

				System.out.print("비밀번호>> ");
				pw = scn.nextLine();

				admin = msc.logIn(id, pw);

				if (admin.equals("admin")) {
					System.out.println("관리자 계정으로 로그인하였습니다");
					admin();
				} else if (admin.equals("user")) {
					System.out.printf("%s님 환영합니다!\n", id);
					user = id;
					user();
				} else {
					System.out.println("아이디와 비밀번호를 확인해주세요");
					break;
				}

				run = false; // 로그인 후에 종료를 눌렀을 때 종료될 수 있게 반복문을 끝냄

				break;
			case 2:
				System.out.print("아이디>> ");
				id = scn.nextLine();

				System.out.print("비밀번호>> ");
				pw = scn.nextLine();

				System.out.print("이름>> ");
				name = scn.nextLine();

				System.out.print("전화번호>> ");
				phone = scn.nextLine();

				System.out.print("이메일>> ");
				email = scn.nextLine();

				Member member = new Member(id, pw, name, phone, email);

				if (msc.addMember(member)) {
					System.out.println("회원가입을 완료하였습니다.");
				}

				break;
			case 3:
				System.out.print("이름>> ");
				name = scn.nextLine();

				System.out.print("전화번호>> ");
				phone = scn.nextLine();

				msc.findId(name, phone);
				break;
			case 4:
				System.out.print("아이디>> ");
				id = scn.nextLine();

				String pwd = msc.findPw(id);

				if (pwd != null) {
					System.out.printf("비밀번호는 %s 입니다.\n", pwd);
				}
				break;
			case 5:
				System.out.println("종료되었습니다.");
				return;
			default:
				System.out.println("다시 입력해주세요");
				break;

			} // switch ~ case
		} // while
	} // execute

	public void logout() {
		System.out.println("로그아웃 하였습니다.");
		execute();
	} // logout

	public int menuCheck(String menu) { // 메뉴항목 입력 체크
		try {
			int result = Integer.parseInt(menu);
			return result;
		} catch (NumberFormatException e) {
			System.out.println("다시 입력해주세요");
			return 0;
		}
	} // menuCheck

	public void admin() { // 관리자 계정일 때
		boolean run = true;
		int menu;

		while (run) {
			System.out.println("-------------------------------------------------");
			System.out.println("1.게시판 2.상품관리 3.회원관리 4.로그아웃 5.종료");
			System.out.print("선택>> ");

			menu = menuCheck(scn.nextLine());
			if (menu == 0) {
				continue;
			}

			switch (menu) {
			case 1: // 게시판
				boolean boardmanager = true;
				while (boardmanager) {
					System.out.println("-------------------------------------------------");
					System.out.println("1.글 목록 2.글 삭제 3.돌아가기");
					System.out.print("선택>> ");

					menu = menuCheck(scn.nextLine());
					if (menu == 0) {
						continue;
					}

					switch (menu) {
					case 1: // 글 목록
						boolean boardlist = false;
						int page = 1;
						List<Board> board = bsc.boardList();

						while (true) {

							int start = (page - 1) * 5;
							int end = page * 5;

							if (!board.isEmpty()) {
								System.out.println("-------------------------------------------------");
								System.out.println("NO   TITLE      WRITER");

								try { // 페이지 5개씩 출력
									for (int i = start; i < end; i++) {
										System.out.printf("%-4d %-10s %s\n", board.get(i).getNo(),
												board.get(i).getTitle(), board.get(i).getWriter());
									}
								} catch (IndexOutOfBoundsException e) {

								}

								System.out.println("-------------------------------------------------");
								System.out.println("상세보기: 글 번호, 이전(P), 다음(N), 메뉴로 이동(Q)");
								System.out.print("선택>> ");
								String result = scn.nextLine();

								if (page == 1 && result.equals("p") || result.equals("P") || result.equals("n")
										|| result.equals("N")) {
									System.out.println("첫 페이지입니다.");
									continue;
								}

								if (end >= board.size() && result.equals("n") || result.equals("N")) {
									System.out.println("마지막 페이지입니다.");
									continue;
								}

								if (result.equals("q") || result.equals("Q")) {
									break;
								} else if (result.equals("n") || result.equals("N")) {
									page++;
								} else if (result.equals("p") || result.equals("P")) {
									page--;
								} else {

									int no = menuCheck(result);
									if (no == 0) { // 메뉴 항목에 해당하지 않은 값이 입력되었을 때
										continue;
									}

									for (int i = 0; i < board.size(); i++) { // 상세정보 출력
										if (board.get(i).getNo() == no) {
											System.out.println("-------------------------------------------------");
											System.out.printf("NO     : %d\n", board.get(i).getNo());
											System.out.printf("TITLE  : %s\n", board.get(i).getTitle());
											System.out.printf("WRITER : %s\n", board.get(i).getWriter());
											System.out.printf("DATE   : %s\n", board.get(i).getUploaddate());
											System.out.printf("CONTENT: %s\n", board.get(i).getContent());
											System.out.println();
											boardlist = true;
											break;
										}
									}

									if (!boardlist) { // 글 번호에 해당하는 글이 없을 때
										System.out.println("해당 글이 없습니다.");
									}

								}

							} else {
								System.out.println("글이 없습니다.");
								break;
							} // if ~ else -- board가 비었는지 체크

						} // while

						break;

					case 2: // 글 삭제
						int boardno;

						while (true) {
							System.out.print("삭제할 글 번호를 입력해주세요>> ");
							boardno = menuCheck(scn.nextLine());

							if (boardno == 0) {
								continue;
							}

							break;
						}

						if (bsc.deleteBoard(boardno)) {
							System.out.println("글이 삭제되었습니다");
						} else {
							System.out.println("해당 글이 존재하지 않습니다.");
						}

						break;

					case 3: // 돌아가기
						boardmanager = false;
						break;

					default:
						System.out.println("다시 입력해주세요");
						break;

					}
				}
				break;

			case 2: // 상품관리
				boolean pdmanager = true;
				while (pdmanager) {
					List<Product> product = psc.ProductList();

					String name;
					int ea;
					int price;
					String country;
					int pdno;

					System.out.println("-------------------------------------------------");
					System.out.println("1.상품목록 2.상품등록 3.상품수정 4.상품삭제 5.돌아가기");
					System.out.print("선택>> ");

					int no = menuCheck(scn.nextLine());
					if (no == 0) {
						continue;
					}

					switch (no) {
					case 1: // 상품목록
						int page = 1;

						while (true) {

							int start = (page - 1) * 5;
							int end = page * 5;

							if (!product.isEmpty()) {
								System.out.println("-------------------------------------------------");
								System.out.println("NO   NAME        PRICE(원)     재고    COUNTRY");

								try { // 페이지 5개씩 출력
									for (int i = start; i < end; i++) {
										System.out.printf("%-4d %-10s %-12d %-6d %s\n", product.get(i).getNo(),
												product.get(i).getName(), product.get(i).getPrice(),
												product.get(i).getEa(), product.get(i).getCountry());
									}
								} catch (IndexOutOfBoundsException e) {

								}

								System.out.println("-------------------------------------------------");
								System.out.println("이전(P), 다음(N), 메뉴로 이동(Q)");
								System.out.print("선택>> ");
								String result = scn.nextLine();

								if (page == 1 && result.equals("p") || result.equals("P") || result.equals("n")
										|| result.equals("N")) {
									System.out.println("첫 페이지입니다.");
									continue;
								}

								if (end >= product.size() && result.equals("n") || result.equals("N")) {
									System.out.println("마지막 페이지입니다.");
									continue;
								}

								if (result.equals("q") || result.equals("Q")) {
									break;
								} else if (result.equals("n") || result.equals("N")) {
									page++;
								} else if (result.equals("p") || result.equals("P")) {
									page--;
								} else {
									System.out.println("다시 선택하세요");
									continue;
								}

							} else {
								System.out.println("상품이 없습니다.");
								break;
							} // if ~ else -- product가 비었는지 체크

						} // while
						break;

					case 2: // 상품등록
						System.out.print("상품 이름>> ");
						name = scn.nextLine();

						while (true) {
							System.out.print("가격>> ");
							price = menuCheck(scn.nextLine());

							if (price == 0) {
								continue;
							}

							break;
						}

						while (true) {
							System.out.print("개수>> ");
							ea = menuCheck(scn.nextLine());

							if (ea == 0) {
								continue;
							}

							break;
						}

						System.out.print("원산지>> ");
						country = scn.nextLine();

						Product addproduct = new Product(name, ea, price, country);

						if (psc.addProduct(addproduct)) {
							System.out.println("상품이 등록되었습니다.");
						}

						break;

					case 3: // 상품수정
						boolean upPd = false;

						while (true) {
							System.out.print("수정할 상품 번호를 입력하세요>> ");
							pdno = menuCheck(scn.nextLine());

							if (pdno == 0) {
								continue;
							}
							break;
						}

						for (int i = 0; i < product.size(); i++) {
							if (pdno == product.get(i).getNo()) {
								upPd = true;
								break;
							}
						}

						if (!upPd) {
							System.out.println("해당 상품이 없습니다.");
							break;
						}

						System.out.print("상품 이름>> ");
						name = scn.nextLine();

						while (true) {
							System.out.print("가격>> ");
							price = menuCheck(scn.nextLine());

							if (price == 0) {
								continue;
							}
							break;
						}

						while (true) {
							System.out.print("개수>> ");
							ea = menuCheck(scn.nextLine());

							if (ea == 0) {
								continue;
							}
							break;
						}

						System.out.print("원산지>> ");
						country = scn.nextLine();

						Product updproduct = new Product(name, ea, price, country);
						updproduct.setNo(pdno);

						if (psc.modifyProduct(updproduct)) {
							System.out.println("수정을 완료하였습니다.");
						}

						break;

					case 4: // 상품삭제
						while (true) {
							System.out.print("삭제할 상품 번호를 입력하세요>> ");
							pdno = menuCheck(scn.nextLine());

							if (pdno == 0) {
								continue;
							}

							break;
						}

						if (psc.removeProduct(pdno)) {
							System.out.println("상품이 삭제되었습니다.");
						} else {
							System.out.println("해당 상품이 존재하지 않습니다.");
						}

						break;

					case 5: // 돌아가기
						pdmanager = false;
						break;

					default:
						System.out.println("다시 입력해주세요");
						break;
					}
				}
				break;

			case 3: // 회원관리
				boolean memmanger = true;
				while (memmanger) {
					System.out.println("-------------------------------------------------");
					System.out.println("1.회원목록 2.회원삭제 3.돌아가기");
					System.out.print("선택>> ");

					int no = menuCheck(scn.nextLine());
					if (no == 0) {
						continue;
					}

					switch (no) {
					case 1: // 회원목록
						List<Member> member = msc.memberList();
						
						if (member.size() > 1) {
							System.out.println("ID         NAME   PHONE        EMAIL");
							for (int i = 0; i < member.size(); i++) {
								if (!member.get(i).getAdmin().equals("admin")) {
									System.out.printf("%-10s %-5s %-11s %s\n", member.get(i).getId(),
											member.get(i).getName(), member.get(i).getPhone(), member.get(i).getEmail());
								}
							}							
						} else {
							System.out.println("회원이 없습니다.");
						}
						
						break;

					case 2: // 회원삭제
						System.out.print("삭제할 아이디를 입력해주세요>> ");
						String id = scn.nextLine();

						if (msc.removeMember(id)) {
							System.out.println("삭제되었습니다.");
						} else {
							System.out.println("해당 아이디가 없습니다.");
						}

						break;

					case 3: // 돌아가기
						memmanger = false;
						break;

					default:
						System.out.println("다시 입력해주세요");
						break;
					} // switch
				} // while

				break;

			case 4: // 로그아웃
				logout();
				return;

			case 5: // 종료
				System.out.println("종료되었습니다.");
				return;

			default:
				System.out.println("다시 입력해주세요");
				break;
			} // switch ~ case

		} // while
	} // admin

	public void user() { // 일반 계정일 때
		boolean run = true;
		int menu;

		while (run) {
			System.out.println("-------------------------------------------------");
			System.out.println("1.게시판 2.쇼핑하기 3.마이페이지 4.로그아웃 5.종료");
			System.out.print("선택>> ");

			menu = menuCheck(scn.nextLine());
			if (menu == 0) {
				continue;
			}

			switch (menu) {
			case 1: // 게시판
				boolean userboard = true;
				while (userboard) {
					List<Board> boardlist = bsc.boardList();
					Board board = new Board();

					String title;
					String content;

					System.out.println("-------------------------------------------------");
					System.out.println("1.글 등록 2.글 목록 3.글 수정 4.글 삭제 5.돌아가기");
					System.out.print("선택>> ");

					menu = menuCheck(scn.nextLine());
					if (menu == 0) {
						continue;
					}

					switch (menu) {
					case 1: // 글 등록
						System.out.print("제목>> ");
						title = scn.nextLine();

						System.out.print("내용>> ");
						content = scn.nextLine();

						Board addboard = new Board(title, content, user);

						if (bsc.addBoard(addboard)) {
							System.out.println("글이 등록되었습니다.");
						}

						break;

					case 2: // 글 목록
						boolean boardchk = false;
						int page = 1;

						while (true) {

							int start = (page - 1) * 5;
							int end = page * 5;

							if (!boardlist.isEmpty()) {
								System.out.println("-------------------------------------------------");
								System.out.println("NO   TITLE      WRITER");

								try { // 페이지 5개씩 출력
									for (int i = start; i < end; i++) {
										System.out.printf("%-4d %-10s %s\n", boardlist.get(i).getNo(),
												boardlist.get(i).getTitle(), boardlist.get(i).getWriter());
									}
								} catch (IndexOutOfBoundsException e) {

								}

								System.out.println("-------------------------------------------------");
								System.out.println("상세보기: 글 번호, 이전(P), 다음(N), 메뉴로 이동(Q)");
								System.out.print("선택>> ");
								String result = scn.nextLine();

								if (page == 1 && result.equals("p") || result.equals("P") || result.equals("n")
										|| result.equals("N")) {
									System.out.println("첫 페이지입니다.");
									continue;
								}

								if (end >= boardlist.size() && result.equals("n") || result.equals("N")) {
									System.out.println("마지막 페이지입니다.");
									continue;
								}

								if (result.equals("q") || result.equals("Q")) {
									break;
								} else if (result.equals("n") || result.equals("N")) {
									page++;
								} else if (result.equals("p") || result.equals("P")) {
									page--;
								} else {

									int no = menuCheck(result);
									if (no == 0) { // 메뉴 항목에 해당하지 않은 값이 입력되었을 때
										continue;
									}

									for (int i = 0; i < boardlist.size(); i++) { // 상세정보 출력
										if (boardlist.get(i).getNo() == no) {
											System.out.println("-------------------------------------------------");
											System.out.printf("NO     : %d\n", boardlist.get(i).getNo());
											System.out.printf("TITLE  : %s\n", boardlist.get(i).getTitle());
											System.out.printf("WRITER : %s\n", boardlist.get(i).getWriter());
											System.out.printf("DATE   : %s\n", boardlist.get(i).getUploaddate());
											System.out.printf("CONTENT: %s\n", boardlist.get(i).getContent());
											System.out.println();
											boardchk = true;
											break;
										}
									}

									if (!boardchk) { // 글 번호에 해당하는 글이 없을 때
										System.out.println("해당 글이 없습니다.");
									}

								} // 상세보기, 이전, 다음

							} else {
								System.out.println("글이 없습니다.");
								break;
							} // if ~ else -- board가 비었는지 체크

						} // while
						break;

					case 3: // 글 수정
						boolean uptboard = false;

						System.out.print("글 번호>> ");
						int no = Integer.parseInt(scn.nextLine());

						for (int i = 0; i < boardlist.size(); i++) {
							if (boardlist.get(i).getNo() == no) {
								if (boardlist.get(i).getWriter().equals(user)) {
									uptboard = true;
									break;
								}
							}
						}

						if (!uptboard) {
							System.out.println("본인이 작성한 글만 수정 가능합니다.");
							break;
						}

						System.out.print("제목>> ");
						title = scn.nextLine();

						System.out.print("내용>> ");
						content = scn.nextLine();

						board = new Board(title, content, user);
						board.setNo(no);

						if (bsc.modifyBoard(board)) {
							System.out.println("글을 수정했습니다.");
						}
						break;

					case 4: // 글 삭제
						boolean delno = false;

						System.out.print("삭제할 글 번호를 입력해주세요>> ");
						int boardno = Integer.parseInt(scn.nextLine());

						for (int i = 0; i < boardlist.size(); i++) {
							if (boardlist.get(i).getNo() == boardno) { // 글 번호가 일치
								if (boardlist.get(i).getWriter().equals(user)) { // 작성자와 계정명이 일치
									if (bsc.deleteBoard(boardno)) {
										System.out.println("글이 삭제되었습니다");
										delno = true;
										break;
									}
								}
							}
						}

						if (!delno) {
							System.out.println("본인이 등록한 글만 삭제할 수 있습니다.");
						}

						break;

					case 5: // 돌아가기
						userboard = false;
						break;

					default:
						System.out.println("다시 입력해주세요");
						break;

					} // switch
				} // while

				break;

			case 2: // 쇼핑하기
				boolean shop = true;

				while (shop) {

					System.out.println("-------------------------------------------------");
					System.out.println("1.상품목록 2.주문목록 3.돌아가기");
					System.out.print("선택>> ");

					int no = menuCheck(scn.nextLine());
					if (no == 0) {
						continue;
					}

					switch (no) {
					case 1:
						int page = 1;

						while (true) {
							List<Product> product = psc.ProductList();
							int start = (page - 1) * 5;
							int end = page * 5;

							if (!product.isEmpty()) {
								System.out.println("-------------------------------------------------");
								System.out.println("NO   NAME        PRICE(원)     재고    COUNTRY");

								try { // 페이지 5개씩 출력
									for (int i = start; i < end; i++) {
										System.out.printf("%-4d %-10s %-12d %-6d %s\n", product.get(i).getNo(),
												product.get(i).getName(), product.get(i).getPrice(),
												product.get(i).getEa(), product.get(i).getCountry());
									}
								} catch (IndexOutOfBoundsException e) {

								}

								System.out.println("-------------------------------------------------");
								System.out.println("주문하기(상품번호), 이전(P), 다음(N), 메뉴로 이동(Q)");
								System.out.print("선택>> ");
								String result = scn.nextLine();

								if (page == 1 && result.equals("p") || result.equals("P") || result.equals("n")
										|| result.equals("N")) {
									System.out.println("첫 페이지입니다.");
									continue;
								}

								if (end >= product.size() && result.equals("n") || result.equals("N")) {
									System.out.println("마지막 페이지입니다.");
									continue;
								}

								if (result.equals("q") || result.equals("Q")) {
									break;
								} else if (result.equals("n") || result.equals("N")) {
									page++;
								} else if (result.equals("p") || result.equals("P")) {
									page--;
								} else {
									boolean buyno = false;

									int buy = menuCheck(result);
									if (buy == 0) { // 메뉴 항목에 해당하지 않은 값이 입력되었을 때
										continue;
									}

									for (int i = 0; i < product.size(); i++) {
										if (product.get(i).getNo() == buy) {
											System.out.print("구매할 갯수>> ");
											int ea = Integer.parseInt(scn.nextLine());

											if (product.get(i).getEa() < ea) {
												System.out.println("재고에 맞게 입력해주세요");
												buyno = true;
												break;
											}

											Order order = new Order(buy, product.get(i).getName(), user, ea,
													product.get(i).getPrice() * ea);
											if (osc.addOrder(order)) {
												System.out.println("상품을 주문하였습니다.");
											}

											Product updateProduct = new Product();
											updateProduct.setNo(buy);
											updateProduct.setEa(-ea);
											psc.updateEa(updateProduct);

											buyno = true;
											break;
										}
									} // for

									if (!buyno) {
										System.out.println("해당 상품이 존재하지 않습니다.");
									}

								} // else

							} else {
								System.out.println("상품이 없습니다.");
								break;
							} // if ~ else -- product가 비었는지 체크

						} // while

						break;

					case 2: // 주문목록
						boolean ordermenu = true;
						while (true) {
							List<Order> order = osc.OrderList();
							if (!order.isEmpty()) {
								ordermenu = true;
								System.out.println("-------------------------------------------------");
								System.out.println("NO   NAME      개수     PRICE(원)");

								for (int i = 0; i < order.size(); i++) {
									System.out.printf("%-4d %-8s %-7d %d\n", order.get(i).getNo(),
											order.get(i).getProductName(), order.get(i).getProductEa(),
											order.get(i).getProductPrice());
								}

								System.out.println("-------------------------------------------------");
								System.out.println("삭제하기(주문번호), 메뉴로 이동(Q)");
								System.out.print("선택>> ");
								String result = scn.nextLine();

								if (result.equals("q") || result.equals("Q")) {
									break;
								} else {
									boolean nock = false;

									int orderno = menuCheck(result);
									if (orderno == 0) { // 메뉴 항목에 해당하지 않은 값이 입력되었을 때
										continue;
									}

									for (int i = 0; i < order.size(); i++) {
										if (order.get(i).getNo() == orderno) {
											nock = true;
											if (osc.removeOrder(orderno)) {
												System.out.println("해당 주문이 삭제되었습니다.");
											}

											Product updateProduct = new Product();
											updateProduct.setEa(order.get(i).getProductEa());
											updateProduct.setNo(order.get(i).getProductNo());
											psc.updateEa(updateProduct);
											ordermenu = false;
											break;
										}
									}

									if (!nock) {
										System.out.println("해당하는 주문이 없습니다.");
									}

								} // else

							} else {

								if (ordermenu) {
									System.out.println("주문이 없습니다.");
									break;
								} else {
									break;
								}
							}
						} // while

						break;

					case 3:
						shop = false;
						break;

					default:
						System.out.println("다시 입력해주세요");
						break;
					}
				}

				break;

			case 3: // 마이페이지
				boolean mypage = true;

				while (mypage) {
					System.out.println("-------------------------------------------------");
					System.out.println("1.정보수정 2.회원탈퇴 3.돌아가기");
					System.out.print("선택>> ");

					int no = menuCheck(scn.nextLine());
					if (no == 0) {
						continue;
					}

					switch (no) {
					case 1: // 정보 수정
						System.out.print("비밀번호>> ");
						String pw = scn.nextLine();

						System.out.print("이름>> ");
						String name = scn.nextLine();

						System.out.print("전화번호>> ");
						String phone = scn.nextLine();

						System.out.print("이메일>> ");
						String email = scn.nextLine();

						Member member = new Member(user, pw, name, phone, email);

						if (msc.modifyMember(member)) {
							System.out.println("회원 정보를 변경하였습니다.");
						}

						break;

					case 2: // 회원탈퇴
						while (true) {
							System.out.print("정말 탈퇴하시겠습니까? (Y / N)>> ");
							String msg = scn.nextLine();

							if (msg.equals("Y") || msg.equals("y")) {
								msc.removeMember(user);
								System.out.println("탈퇴가 완료되었습니다.");
								execute();
								return;
							} else if (msg.equals("N") || msg.equals("n")) {
								break;
							} else {
								System.out.println("다시 입력해주세요");
							}
						}
						break;

					case 3: // 돌아가기
						mypage = false;
						break;

					default:
						System.out.println("다시 입력해주세요");
						break;
					}
				}
				break;

			case 4: // 로그아웃
				logout();
				return;
			case 5: // 종료
				System.out.println("종료되었습니다.");
				return;

			default:
				System.out.println("다시 입력해주세요");
				break;
			} // switch ~ case
		} // while

	} // user
}
