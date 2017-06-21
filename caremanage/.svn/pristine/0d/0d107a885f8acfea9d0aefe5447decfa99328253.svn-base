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
public class TreeJudgeModelService {
	/**
	 * 基于logistics和Fisher模型进行数据处理
	 * @param m
	 * @return
	 */

	public MAssessResult disability(MAssessHandleTree mTree){
		MAssessResult mAssessResult = new MAssessResult();
		mAssessResult.setCreatedAt(new Date());
		//决策树
		StringBuffer sql = new StringBuffer();
		switch (mTree.getECon()) {
		case 0:
			switch (mTree.getAge()) {
			case 1: // <70
			case 2:	 //70-74
				mAssessResult.setTreeDisability(12.134);
				break;
			case 3: //75-79
				switch (mTree.getGJibing()) {
				case 1: //有疾病
					switch (mTree.getF31()) {
					case 1: //做家务多
						mAssessResult.setTreeDisability(24.762);
						break;
					case 2: //做家务少   mTree.getF38()=社会活动
						switch (mTree.getF38()) {
						case 1:  //社会活动 多
							mAssessResult.setTreeDisability(0.000);
							mAssessResult.setTreeHealthy(100.00);
							break;
						case 2:
							mAssessResult.setTreeDisability(59.459);
							break;

						default:
							break;
						}
						break;
					}
					break;
				case 2: //没有疾病
					mAssessResult.setTreeDisability(11.712);
					break;
				default:
					break;
				}
				break;
			case 4:  //80-84
				switch (mTree.getSheng()) {
				case 1:
				case 3:
				case 4:
					mAssessResult.setTreeDisability(31.765);
					break;
				case 2:
					mAssessResult.setTreeDisability(83.333);
					break;
				default:
					break;
				}
				break;
			case 5: //  >=85
				switch (mTree.getF31()) {
				case 1: //做家务多
					switch (mTree.getB23()) { //恐惧焦虑
					case 1:   //严重
						mAssessResult.setTreeDisability(82.143);
						break;
					case 2:	// 有时
						sql.append(mTree.getB23());
						switch (mTree.getSheng()) {
						case 1: //东部
							mAssessResult.setTreeDisability(43.590);
							break;
						case 2: //东北部
						case 4:	//西部
							mAssessResult.setTreeDisability(60.606);
							break;
						case 3:	 //中部
							switch (mTree.getGJibing()) {
							case 1:  //有疾病
								mAssessResult.setTreeDisability(0.000);
								break;
							case 2:  //无疾病
								switch (mTree.getB24()) { //孤独程度
								case 1:  //有时候
									mAssessResult.setTreeDisability(100.000);
									break;
								case 2:  // 很少
									mAssessResult.setTreeDisability(0.000);
									break;
								case 3:  // 严重
									mAssessResult.setTreeDisability(0.000);
									break;
								default:
									break;
								}
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
							mAssessResult.setTreeDisability(20.000); 
							break;
						case 2: //参加社会活动少
							switch (mTree.getSheng()) {
							case 1: //东部
								mAssessResult.setTreeDisability(37.500);
								break;
							case 2:	//东北部
							case 3:	//中部
								mAssessResult.setTreeDisability(59.633);
								break;
							case 4:	//西部
								switch (mTree.getSex()) {
								case 1:   // 男
									mAssessResult.setTreeDisability(17.391);
									break;
								case 2:   // 女
									switch (mTree.getB24()) { //孤独程度
									case 1:  //有时候
									case 3:  // 严重
										mAssessResult.setTreeDisability(66.667);
										break;
									case 2:  // 很少
										mAssessResult.setTreeDisability(43.243);
										break;
									default:
										break;
									}
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
					switch(mTree.getLivewith()){
					case 1:
					case 2:
						mAssessResult.setTreeDisability(66.825);
						break;
					case 3:
						mAssessResult.setTreeDisability(35.000);
					}
					break;
				}
				break;
			default:
				break;
			}
			break;
		case 1:
			mAssessResult.setTreeDisability(89.391);
			break;
		default:
			break;
		}
		return mAssessResult ;
		
	}

}
