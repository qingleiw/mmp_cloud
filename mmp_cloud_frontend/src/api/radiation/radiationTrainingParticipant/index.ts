import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import {
  RadiationTrainingParticipantVO,
  RadiationTrainingParticipantForm,
  RadiationTrainingParticipantQuery
} from '@/api/system/radiationTrainingParticipant/types';

/**
 * 查询培训参与记录列表
 * @param query
 * @returns {*}
 */

export const listRadiationTrainingParticipant = (query?: RadiationTrainingParticipantQuery): AxiosPromise<RadiationTrainingParticipantVO[]> => {
  return request({
    url: '/system/radiationTrainingParticipant/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询培训参与记录详细
 * @param id
 */
export const getRadiationTrainingParticipant = (id: string | number): AxiosPromise<RadiationTrainingParticipantVO> => {
  return request({
    url: '/system/radiationTrainingParticipant/' + id,
    method: 'get'
  });
};

/**
 * 新增培训参与记录
 * @param data
 */
export const addRadiationTrainingParticipant = (data: RadiationTrainingParticipantForm) => {
  return request({
    url: '/system/radiationTrainingParticipant',
    method: 'post',
    data: data
  });
};

/**
 * 修改培训参与记录
 * @param data
 */
export const updateRadiationTrainingParticipant = (data: RadiationTrainingParticipantForm) => {
  return request({
    url: '/system/radiationTrainingParticipant',
    method: 'put',
    data: data
  });
};

/**
 * 删除培训参与记录
 * @param id
 */
export const delRadiationTrainingParticipant = (id: string | number | Array<string | number>) => {
  return request({
    url: '/system/radiationTrainingParticipant/' + id,
    method: 'delete'
  });
};
