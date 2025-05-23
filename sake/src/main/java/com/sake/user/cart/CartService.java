@Service
public class CartService {

	@Autowired
	CartDao dao;
	
	public List<CartDto> cartList(CartDto dto){
		return dao.cartList(dto);
	}
	
	public int cartInsert(CartDto dto) {
		return dao.cartInsert(dto);
	}
	
	public int cartDelete(String cart_id) {
		return dao.cartDelete(cart_id);
	}
}
