import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import {
  RadiationEquipmentInspectionVO,
  RadiationEquipmentInspectionForm,
  RadiationEquipmentInspectionQuery
} from '@/api/radiation/radiationEquipmentInspection/types';

/**
 * 查询放射设备检测记录列表
 * @param query
 * @returns {*}
 */

export const listRadiationEquipmentInspection = (query?: RadiationEquipmentInspectionQuery): AxiosPromise<RadiationEquipmentInspectionVO[]> => {
  return request({
    url: '/radiation/radiationEquipmentInspection/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询放射设备检测记录详细
 * @param id
 */
export const getRadiationEquipmentInspection = (id: string | number): AxiosPromise<RadiationEquipmentInspectionVO> => {
  return request({
    url: '/radiation/radiationEquipmentInspection/' + id,
    method: 'get'
  });
};

/**
 * 新增放射设备检测记录
 * @param data
 */
export const addRadiationEquipmentInspection = (data: RadiationEquipmentInspectionForm) => {
  return request({
    url: '/radiation/radiationEquipmentInspection',
    method: 'post',
    data: data
  });
};

/**
 * 修改放射设备检测记录
 * @param data
 */
export const updateRadiationEquipmentInspection = (data: RadiationEquipmentInspectionForm) => {
  return request({
    url: '/radiation/radiationEquipmentInspection',
    method: 'put',
    data: data
  });
};

/**
 * 删除放射设备检测记录
 * @param id
 */
export const delRadiationEquipmentInspection = (id: string | number | Array<string | number>) => {
  return request({
    url: '/radiation/radiationEquipmentInspection/' + id,
    method: 'delete'
  });
};
