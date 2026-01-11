export interface DoctorPublicationVO {
  /**
   * 主键ID
   */
  id: string | number;

  /**
   * 医生ID
   */
  doctorId: string | number;

  /**
   * 类型 论文/论著/专利
   */
  publicationType: string;

  /**
   * 标题
   */
  title: string;

  /**
   * 作者
   */
  authors: string;

  /**
   * 作者排序
   */
  authorOrder: number;

  /**
   * 期刊名称/出版社
   */
  journalName: string;

  /**
   * 发表日期
   */
  publishDate: string;

  /**
   * 卷号
   */
  volume: string;

  /**
   * 期号
   */
  issue: string;

  /**
   * 页码
   */
  pages: string;

  /**
   * DOI
   */
  doi: string;

  /**
   * 影响因子
   */
  impactFactor: number;

  /**
   * 引用次数
   */
  citationCount: number;

  /**
   * 全文URL
   */
  fullTextUrl: string;

  /**
   * 是否删除
   */
  delFlag: string;
}

export interface DoctorPublicationForm extends BaseEntity {
  /**
   * 主键ID
   */
  id?: string | number;

  /**
   * 医生ID
   */
  doctorId?: string | number;

  /**
   * 类型 论文/论著/专利
   */
  publicationType?: string;

  /**
   * 标题
   */
  title?: string;

  /**
   * 作者
   */
  authors?: string;

  /**
   * 作者排序
   */
  authorOrder?: number;

  /**
   * 期刊名称/出版社
   */
  journalName?: string;

  /**
   * 发表日期
   */
  publishDate?: string;

  /**
   * 卷号
   */
  volume?: string;

  /**
   * 期号
   */
  issue?: string;

  /**
   * 页码
   */
  pages?: string;

  /**
   * DOI
   */
  doi?: string;

  /**
   * 影响因子
   */
  impactFactor?: number;

  /**
   * 引用次数
   */
  citationCount?: number;

  /**
   * 全文URL
   */
  fullTextUrl?: string;

  /**
   * 是否删除
   */
  delFlag?: string;
}

export interface DoctorPublicationQuery extends PageQuery {
  /**
   * 医生ID
   */
  doctorId?: string | number;

  /**
   * 类型 论文/论著/专利
   */
  publicationType?: string;

  /**
   * 标题
   */
  title?: string;

  /**
   * 作者
   */
  authors?: string;

  /**
   * 作者排序
   */
  authorOrder?: number;

  /**
   * 期刊名称/出版社
   */
  journalName?: string;

  /**
   * 发表日期
   */
  publishDate?: string;

  /**
   * 卷号
   */
  volume?: string;

  /**
   * 期号
   */
  issue?: string;

  /**
   * 页码
   */
  pages?: string;

  /**
   * DOI
   */
  doi?: string;

  /**
   * 影响因子
   */
  impactFactor?: number;

  /**
   * 引用次数
   */
  citationCount?: number;

  /**
   * 全文URL
   */
  fullTextUrl?: string;

  /**
   * 是否删除
   */
  delFlag?: string;

  /**
   * 日期范围参数
   */
  params?: any;
}
