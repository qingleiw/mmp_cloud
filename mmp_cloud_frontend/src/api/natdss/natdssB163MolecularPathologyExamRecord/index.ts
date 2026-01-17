import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { NatdssB163MolecularPathologyExamRecordVO, NatdssB163MolecularPathologyExamRecordForm, NatdssB163MolecularPathologyExamRecordQuery } from '@/api/natdss/natdssB163MolecularPathologyExamRecord/types';

/**
 * 查询B162 分子病理检测记录列表
 * @param query
 * @returns {*}
 */

export const listNatdssB163MolecularPathologyExamRecord = (query?: NatdssB163MolecularPathologyExamRecordQuery): AxiosPromise<NatdssB163MolecularPathologyExamRecordVO[]> => {
  return request({
    url: '/natdss/natdssB163MolecularPathologyExamRecord/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询B162 分子病理检测记录详细
 * @param id
 */
export const getNatdssB163MolecularPathologyExamRecord = (id: string | number): AxiosPromise<NatdssB163MolecularPathologyExamRecordVO> => {
  return request({
    url: '/natdss/natdssB163MolecularPathologyExamRecord/' + id,
    method: 'get'
  });
};

/**
 * 新增B162 分子病理检测记录
 * @param data
 */
export const addNatdssB163MolecularPathologyExamRecord = (data: NatdssB163MolecularPathologyExamRecordForm) => {
  return request({
    url: '/natdss/natdssB163MolecularPathologyExamRecord',
    method: 'post',
    data: data
  });
};

/**
 * 修改B162 分子病理检测记录
 * @param data
 */
export const updateNatdssB163MolecularPathologyExamRecord = (data: NatdssB163MolecularPathologyExamRecordForm) => {
  return request({
    url: '/natdss/natdssB163MolecularPathologyExamRecord',
    method: 'put',
    data: data
  });
};

/**
 * 删除B162 分子病理检测记录
 * @param id
 */
export const delNatdssB163MolecularPathologyExamRecord = (id: string | number | Array<string | number>) => {
  return request({
    url: '/natdss/natdssB163MolecularPathologyExamRecord/' + id,
    method: 'delete'
  });
};
