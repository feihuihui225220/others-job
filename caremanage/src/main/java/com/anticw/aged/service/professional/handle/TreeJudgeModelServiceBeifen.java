package com.anticw.aged.service.professional.handle;
/**
 * @author bsd
 * @失能失智模型处理
 */
import java.util.Date;

import org.springframework.stereotype.Service;

import com.anticw.aged.bean.MAssessHandleTree;
import com.anticw.aged.bean.MAssessResult;

@Service
public class TreeJudgeModelServiceBeifen {
	/**
	 * 基于logistics和Fisher模型进行数据处理
	 * @param m
	 * @return
	 */
/*
	@Autowired
	private HandleDao handleDao;*/
	
	public StringBuffer disability(MAssessHandleTree mTree){
		MAssessResult mAssessResult = new MAssessResult();
		
		mAssessResult.setCreatedAt(new Date());
		//决策树
		StringBuffer sql = new StringBuffer();
		switch (mTree.getECon()) {
		case 0:
			sql.append(" and ECon ="+mTree.getECon());
			switch (mTree.getAge()) {
			case 1: // <70
			case 2:	 //70-74
				sql.append(" and age ="+mTree.getAge());
				break;
			case 3: //75-79
				switch (mTree.getGJibing()) {
				case 1: //有疾病
					sql.append( " and GJibing="+mTree.getGJibing());
					switch (mTree.getF31()) {
					case 1: //做家务多
						sql.append(" and f31="+mTree.getF31());
						break;
					case 2: //做家务少   mTree.getF38()=社会活动
						sql.append(" and f31="+mTree.getF31()+" f38="+mTree.getF38());
						break;
					}
					break;
				case 2: //没有疾病
					sql.append("");
					break;
				default:
					break;
				}
				break;
			case 4:  //80-84
				sql.append(" and sheng=" + mTree.getSheng());
				break;
			case 5: //  >=85
				switch (mTree.getF31()) {
				case 1: //做家务多
					sql.append(" and f31="+mTree.getF31());
					switch (mTree.getB23()) { //恐惧焦虑
					case 1:   //严重
						sql.append(mTree.getB23());
						break;
					case 2:	// 有时
						sql.append(mTree.getB23());
						switch (mTree.getSheng()) {
						case 1: //东部
						case 2: //东北部
						case 4:	//西部
							sql.append(" and sheng = "+mTree.getSheng());
							break;
						case 3:	 //中部
							sql.append(" and sheng = "+mTree.getSheng());
							switch (mTree.getGJibing()) {
							case 1:  //有疾病
								sql.append(" and GJibing = " +mTree.getGJibing());
								break;
							case 2:  //无疾病
								sql.append(" and GJibing = " +mTree.getGJibing());
								//孤独程度
								sql.append(" and b24 = " +mTree.getB24());
								break;
							default:
								break;
							}
							break;
						default:
							break;
						}
						break;
					case 3:	// 很少
						sql.append(mTree.getB23());
						switch (mTree.getF38()) {
						case 1: //参加社会活动多
							sql.append(" and f38="+mTree.getF38());
							break;
						case 2: //参加社会活动少
							sql.append(" and f38="+mTree.getF38());
							switch (mTree.getSheng()) {
							case 1: //东部
							case 2:	//东北部
							case 3:	//中部
								sql.append(" and sheng="+mTree.getSheng());
								break;
							case 4:	//西部
								sql.append(" and sheng="+mTree.getSheng());
								switch (mTree.getSex()) {
								case 1:   // 男
									sql.append(" and sex = "+mTree.getSex());
									break;
								case 2:   // 女
									sql.append(" and sex = "+mTree.getSex());
									//孤独程度
									sql.append(" and b24 = " +mTree.getB24());
									break;
								default:
									break;
								}
							default:
								break;
							}
						default:
							break;
						}
						break;
					default:
						break;
					}
					break;
				case 2: //做家务少   mTree.getLivewith()=居住情况
					sql.append(" and f31="+mTree.getF31()+" livewith="+mTree.getLivewith());
					break;
				}
				break;
			default:
				break;
			}
			break;
		case 1:
			sql.append(" and ECon ="+mTree.getECon());
			break;
		default:
			break;
		}
		return sql ;
		
	}

}
