import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { NatdssB16-3MolecularPathologyExamRecordVO, NatdssB16-3MolecularPathologyExamRecordForm, NatdssB16-3MolecularPathologyExamRecordQuery } from '@/api/natdss/natdssB16-3MolecularPathologyExamRecord/types';

/**
 * 查询B16-3 分子病理检测记录列表
 * @param query
 * @returns {*}
 */

export const listNatdssB16-3MolecularPathologyExamRecord = (query?: NatdssB16-3MolecularPathologyExamRecordQuery): AxiosPromise<NatdssB16-3MolecularPathologyExamRecordVO[]> => {
  return request({
    url: '/natdss/natdssB16-3MolecularPathologyExamRecord/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询B16-3 分子病理检测记录详细
 * @param id
 */
export const getNatdssB16-3MolecularPathologyExamRecord = (id: string | number): AxiosPromise<NatdssB16-3MolecularPathologyExamRecordVO> => {
  return request({
    url: '/natdss/natdssB16-3MolecularPathologyExamRecord/' + id,
    method: 'get'
  });
};

/**
 * 新增B16-3 分子病理检测记录
 * @param data
 */
export const addNatdssB16-3MolecularPathologyExamRecord = (data: NatdssB16-3MolecularPathologyExamRecordForm) => {
  return request({
    url: '/natdss/natdssB16-3MolecularPathologyExamRecord',
    method: 'post',
    data: data
  });
};

/**
 * 修改B16-3 分子病理检测记录
 * @param data
 */
export const updateNatdssB16-3MolecularPathologyExamRecord = (data: NatdssB16-3MolecularPathologyExamRecordForm) => {
  return request({
    url: '/natdss/natdssB16-3MolecularPathologyExamRecord',
    method: 'put',
    data: data
  });
};

/**
 * 删除B16-3 分子病理检测记录
 * @param id
 */
export const delNatdssB16-3MolecularPathologyExamRecord = (id: string | number | Array<string | number>) => {
  return request({
    url: '/natdss/natdssB16-3MolecularPathologyExamRecord/' + id,
    method: 'delete'
  });
};
